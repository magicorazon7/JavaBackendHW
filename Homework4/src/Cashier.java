
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

                try {
                    processTransaction(t);
                } catch (Exception ex) {
                    bank.notifyObservers("Cashier " + id + " failed transaction: " + ex.getMessage());
                    ex.printStackTrace();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public synchronized void deposit(int clientId, double amount) {
        if (amount <= 0) {
            bank.notifyObservers("Deposit failed: invalid amount " + amount);
            return;
        }

        Client client = bank.getClient(clientId);
        if (client == null) {
            bank.notifyObservers("Deposit failed: client " + clientId + " not found");
            return;
        }

        try {
            double balance = client.getBalance();
            client.setBalance(balance + amount);
            bank.notifyObservers("Deposit successful: client " + clientId + " new balance " + client.getBalance());
        } catch (Exception e) {
            bank.notifyObservers("Deposit error for client " + clientId + ": " + e.getMessage());
        }
    }

    public boolean withdraw(int clientId, double amount) {
        if (amount <= 0) {
            bank.notifyObservers("Withdraw failed: invalid amount " + amount);
            return false;
        }

        Client client = bank.getClient(clientId);
        if (client == null) {
            bank.notifyObservers("Withdraw failed: client " + clientId + " not found");
            return false;
        }

        try {
            double balance = client.getBalance();
            if (balance >= amount) {
                client.setBalance(balance - amount);
                bank.notifyObservers("Withdraw successful: client " + clientId + " new balance " + client.getBalance());
                return true;
            } else {
                bank.notifyObservers("Withdraw failed: insufficient funds for client " + clientId);
                return false;
            }
        } catch (Exception e) {
            bank.notifyObservers("Withdraw error for client " + clientId + ": " + e.getMessage());
            return false;
        }
    }
    
    
    public void exchangeCurrency(int clientId, Currency from, Currency to) {
        Client client = bank.getClient(clientId);

        if (client.getBalance() <= 0) {
            bank.notifyObservers("Currency exchange failed: insufficient funds ");
            return;
        }

        if (client == null) {
              bank.notifyObservers("Operation failed: no such client " + clientId);
              return;
        }
        if (!client.getCurrency().equals(from)) {
              bank.notifyObservers("Operation failed: client " + clientId + " doesn't possess " + from);
              return;
        }

        double fromRate = bank.getExchangeRate(from);
        double toRate = bank.getExchangeRate(to);
        double converted = client.getBalance() * (toRate / fromRate);
        deposit(clientId,converted);
        client.setCurrency(to);
          
      }


    public synchronized void transferFunds(int senderId, int receiverId, double amount) {
        Client sender = bank.getClient(senderId);
        Client receiver = bank.getClient(receiverId);

        if (sender == null|receiver == null) {
            bank.notifyObservers("Operation failed: invalid clients");
            return;
        }

        synchronized (sender) { // блокируем и сендера и ресивера
            synchronized (receiver) {
                if (!withdraw(senderId, amount)) {
                    bank.notifyObservers("Transfer failed: insufficient funds " + senderId);
                    return;
                }

                Currency senderCur = sender.getCurrency();
                Currency receiverCur = receiver.getCurrency();

                if(!senderCur.equals(receiverCur)){
                    double fromRate = bank.getExchangeRate(senderCur);
                    double toRate = bank.getExchangeRate(receiverCur);
                    amount = amount * (toRate / fromRate);
                } // при переводе с одной валюты в другую

                deposit(receiverId, amount);
                bank.notifyObservers("Transfer completed: " + senderId + " -> " + receiverId);
            }
        }
      }

    private void processTransaction(Transaction t) {
        switch (t.type) {
            case DEPOSIT -> deposit(t.clientId, t.amount);
            case WITHDRAW -> withdraw(t.clientId, t.amount);
            case EXCHANGE -> exchangeCurrency(t.clientId, t.from, t.to);
            case TRANSFER -> transferFunds(t.clientId, t.receiverId, t.amount);
        }
    }
}
