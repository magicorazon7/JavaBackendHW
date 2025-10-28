
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("##Starting Simple Bank Test##");
        
        Bank bank = new Bank(5);
//        Cashier cashier = new Cashier(bank);
//
//        // первые клиенты алмазэргиенбанка
//        bank.addClient(new Client(1, 1000.0, Currency.USD));
//        bank.addClient(new Client(2, 500.0, Currency.EUR));
//        bank.addClient(new Client(3, 750.0, Currency.RUB));
//        bank.addClient(new Client(4, 800.0, Currency.USD));
//
//        System.out.println("\n##Testing Operations##");
//
//        cashier.transferFunds(1, 4, 100.0);
//        cashier.transferFunds(1, 2, 50.0);
//        System.out.println(bank.getClient(1).getBalance());
//        cashier.exchangeCurrency(1, Currency.USD, Currency.EUR, 200.0);
        
        System.out.println("\n##Waiting for rate updates (30 seconds)##");
        Thread.sleep(30000);
        
        System.out.println("##Test completed##");
        System.exit(0); // Force exit since we have scheduled threads running
    }
}