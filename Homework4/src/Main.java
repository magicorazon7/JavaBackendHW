
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("##Starting Simple Bank Test##");
        // Банк с двумя кассирами
        Bank bank = new Bank(2);

        // Довольные пользователи Алмазэргиенбанка
        bank.addClient(new Client(1, 1000.0, Currency.USD));
        bank.addClient(new Client(2, 500.0, Currency.USD));
        bank.addClient(new Client(3, 800.0, Currency.RUB));
        bank.addClient(new Client(4, 800.0, Currency.RUB));

        // Добавить в очередь операции
        bank.submitTransaction(new Transaction(Transaction.Type.DEPOSIT, 1, 0, null, null, 200));
        bank.submitTransaction(new Transaction(Transaction.Type.DEPOSIT, 4, 0, null, null, 200));
        bank.submitTransaction(new Transaction(Transaction.Type.WITHDRAW, 2, 0, null, null, 100));
        bank.submitTransaction(new Transaction(Transaction.Type.TRANSFER, 1, 2, null, null, 150));
        bank.submitTransaction(new Transaction(Transaction.Type.EXCHANGE, 3, 0, Currency.RUB, Currency.USD, 0));

        Thread.sleep(10000);
        System.out.println("\nFinal balances:");
        for (int id = 1; id <= bank.getNumberOfClients(); id++) {
            Client c = bank.getClient(id);
            System.out.println("Client "+c.getId()+":" + c.getBalance() +" "+c.getCurrency());
        }

        System.exit(0);
    }
}