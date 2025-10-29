public class Logger implements Observer {
    @Override
    public void update(String message) {
// Здесь ваш код для логгирования, например:
        System.out.printf("[%s] Log: %s%n", java.time.LocalTime.now(), message);
    }
}
