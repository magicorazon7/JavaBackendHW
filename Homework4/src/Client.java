public class Client {
    private final int id;
    private double balance;
    private Currency currency;

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
    public synchronized Currency getCurrency() { return currency; }
    public synchronized void setCurrency(Currency currency) {this.currency = currency;}

}
