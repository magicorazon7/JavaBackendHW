
public class Cashier extends Thread {
    Bank bank;
    private final int id;
    private volatile boolean running = true;
  
    public Cashier(int id, Bank bank) {
      this.id = id;
      this.bank = bank;
    }
  
    @Override
    public void run() {
      while (running) {
        try {
          Transaction t = bank.takeTransaction();
          bank.notifyObservers("Cashier " + id + " processing transaction");
          processTransaction(t);
          
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            break;
        }
      }
    }
    
    public void deposit(int clientId, double amount) {
      double balance = bank.getClient(clientId).getBalance();
      balance += amount;
      bank.getClient(clientId).setBalance(balance);
    }
  
    public boolean withdraw(int clientId, double amount) {
      double balance = bank.getClient(clientId).getBalance();
      if (balance >= amount) {
      balance -= amount;
      bank.getClient(clientId).setBalance(balance);
      System.out.println("withdrawal successful");
      return true;
    }
      System.out.println("Non-successful withdrawal");
      return false;
    }
    
    
    public void exchangeCurrency(int clientId, Currency from, Currency to, double amount) {
          Client client = bank.getClient(clientId);
          if (client == null) {
              bank.notifyObservers("Operation failed: no such client " + clientId);
              return;
          }
          if (!client.getCurrency().equals(from)) {
              bank.notifyObservers("Operation failed: client " + clientId + " doesn't possess " + from);
              return;
          }
          if (!withdraw(clientId, amount)) {
              bank.notifyObservers("Operation failed: insufficient funds " + clientId);
              return;
          }

          double fromRate = bank.getExchangeRate(from);
          double toRate = bank.getExchangeRate(to);
          double converted = amount * (toRate / fromRate);
          deposit(clientId,converted);
          
      }


    public synchronized void transferFunds(int senderId, int receiverId, double amount) {
        Client sender = bank.getClient(senderId);
        Client receiver = bank.getClient(receiverId);

        synchronized (sender) { // блокируем и сендера и ресивера
            synchronized (receiver) {
                if (!withdraw(senderId, amount)) {
                    bank.notifyObservers("Transfer failed: insufficient funds " + senderId);
                    return;
                }
                deposit(receiverId, amount);
                bank.notifyObservers("Transfer completed: " + senderId + " -> " + receiverId);
            }
        }
      }

    private void processTransaction(Transaction t) {
        switch (t.type) {
            case DEPOSIT -> deposit(t.clientId, t.amount);
            case WITHDRAW -> withdraw(t.clientId, t.amount);
            case EXCHANGE -> exchangeCurrency(t.clientId, t.from, t.to, t.amount);
            case TRANSFER -> transferFunds(t.clientId, t.receiverId, t.amount);
        }
    }
}
