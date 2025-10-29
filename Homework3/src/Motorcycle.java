import java.util.List;

public final class Motorcycle extends Vehicle implements HasEngine {
    public Motorcycle(String name, int maxSpeed) {
        super(name, maxSpeed, List.of(new GasolineFuel()), TransportCategory.land);
    }

    @Override
    public void startEngine() {
        System.out.println("Motorcycle's engine started!");
    }
    
    @Override
    public void stopEngine() {
    
    }
    
    @Override
    public void startMotion() {
        System.out.println("Motorcycle's accelerating!");
    }

    @Override
    public void endMotion() {
        System.out.println("Motorcycle's stopped!");
    }
}
