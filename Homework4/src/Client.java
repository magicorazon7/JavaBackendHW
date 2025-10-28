public class Client {
    private final int id;
    private double balance;
    private final Currency currency;

    public Client(int id, double balance, Currency currency1) {
        this.id = id;
        this.balance = balance;
        this.currency = currency1;
    }
    
    public synchronized double getBalance() { return balance; }
    public synchronized void setBalance(double amount) {
        balance = amount;
    }
    
    public int getId() { return id; }
    public Currency getCurrency() { return currency; }

}
