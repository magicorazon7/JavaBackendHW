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
}