import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    public Bank() {
        addObserver(new Logger()); // automatically attach logger
    }

    private final ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Currency, Double> exchangeRates = new ConcurrentHashMap<>();

    public void addClient(Client c) {
        clients.put(c.getId(), c);
    }

    public Client getClient(int id) {
        return clients.get(id);
    }

    public void setExchangeRate(Currency currency, double rate) {
        exchangeRates.put(currency, rate);
    }

    public double getExchangeRate(Currency currency) {
        return exchangeRates.getOrDefault(currency, 1.0);
    }

    private List<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void notifyObservers(String message) {
        for (Observer o: observers) {
            o.update(message);
        }
    }


    public synchronized void exchangeCurrency(int clientId, Currency from, Currency to, double amount) {
        Client client = clients.get(clientId);
        if (client == null) {
            notifyObservers("Транзакция провалилась: не существует клиента с ID " + clientId);
            return;
        }
        if (!client.getCurrency().equals(from)) {
            notifyObservers("Транзакция провалилась: клиент " + clientId + " не использует валюту " + from);
            return;
        }
        if (!client.withdraw(amount)) {
            notifyObservers("Транзакция провалилась: недостаточно средств " + clientId);
            return;
        }

        double fromRate = getExchangeRate(from);
        double toRate = getExchangeRate(to);
        double converted = amount * (toRate / fromRate);
        client.deposit(converted);

        //  notifyObservers
    }


    public synchronized void transferFunds(int senderId, int receiverId, double amount) {
        Client sender = clients.get(senderId);
        Client receiver = clients.get(receiverId);

        if (sender == null || receiver == null) {
            notifyObservers("Транзакция правлилась: недействительный ID");
            return;
        }
        if (!sender.withdraw(amount)) {
            notifyObservers("Транзакция правлилась недостаточно средств у клиента " + senderId);
            return;
        }

    }
}