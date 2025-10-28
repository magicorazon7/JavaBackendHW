import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Bank {
    
    private final ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Currency, Double> exchangeRates = new ConcurrentHashMap<>();
    private final BlockingQueue<Runnable> transactionQueue = new LinkedBlockingQueue<>();
    private final List<Cashier> cashiers = new CopyOnWriteArrayList<>();
    private List<Observer> observers = new CopyOnWriteArrayList<>();

    public Bank(int numberOfCashiers) {
        initializeExchangeRates();
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(() -> {updateExchangeRates();},
        0, 10, TimeUnit.SECONDS);
        
        for (int i = 0; i < numberOfCashiers; i++) {
            Cashier cashier = new Cashier(i, this);
            cashiers.add(cashier);
            cashier.start();
        }
        
        addObserver(new Logger());
    }
    
    public void submitTransaction(Runnable transaction) {
        transactionQueue.offer(transaction);
    }
    
    public Runnable takeTransaction() throws InterruptedException {
        return transactionQueue.take();
    }
    
    // работа с клиентами
    public void addClient(Client c) {
        clients.put(c.getId(), c);
    }
    public Client getClient(int id) {
        return clients.get(id);
    }
    
    // работа с валютой
    public void setExchangeRate(Currency currency, double rate) {
        exchangeRates.put(currency, rate);
    }
    public double getExchangeRate(Currency currency) {
        return exchangeRates.getOrDefault(currency, 1.0);
    }

    // обсерверы
    void addObserver(Observer observer) {
        observers.add(observer);
    }
    void notifyObservers(String message) {
        for (Observer o: observers) {
            o.update(message);
        }
    }
    
    // инициализация валют
    private void initializeExchangeRates() {
        exchangeRates.put(Currency.USD, 1.0);
        exchangeRates.put(Currency.EUR, 0.92);
        exchangeRates.put(Currency.RUB, 0.5);
        
        notifyObservers("Initial rates set " + exchangeRates);
    }
    
    private void updateExchangeRates() {
        // изменение в валютах -2 - +2 процента
        for (Currency currency : exchangeRates.keySet()) {
            if (currency != Currency.USD) { // баксы - относительная валюта
                double currentRate = exchangeRates.get(currency);
                double change = (Math.random() * 0.05) - 0.02; // -2% to +2%
                double newRate = currentRate * (1 + change);
                exchangeRates.put(currency, newRate);
            }
        }
        notifyObservers("Rates updated: " + exchangeRates);
    }
}