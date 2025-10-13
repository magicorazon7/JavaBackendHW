import java.util.List;

public final class ElectricCar extends Vehicle implements HasEngine {
    public ElectricCar(String name, int maxSpeed) {
        super(name, maxSpeed, List.of(new ElectricFuel()), TransportCategory.land);
    }

    @Override
    public void startEngine() {
        System.out.println("Electric drive is booted up!");
    }
    
    @Override
    public void stopEngine() {
    
    }
    
    @Override
    public void startMotion() {
        System.out.println("Electric car is accelerating!");
    }

    @Override
    public void endMotion() {
        System.out.println("Electric car stopped moving!");
    }
}
