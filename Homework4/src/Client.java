public class Client {
    private final int id;
    private double balance;
    private final Currency currency;

    public Client(int id, double balance, Currency currency1) {
        this.id = id;
        this.balance = balance;
        this.currency = currency1;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("withdrawal successful");
            return true;
        }
        System.out.println("Non-successful withdrawal");
        return false;
    }

    public int getId() { return id; }
    public Currency getCurrency() { return currency; }
    public synchronized double getBalance() { return balance; }

}
