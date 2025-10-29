import java.util.List;

public final class GasCar extends Vehicle implements HasEngine {
    public GasCar (String name, int maxSpeed){
        super(name, maxSpeed, List.of(new GasolineFuel()), TransportCategory.land);
    }

    @Override
    public void startEngine() {
        System.out.println("Car's engine started!");
    }
    
    @Override
    public void stopEngine() {
    
    }
    
    @Override
    public void startMotion() {
        System.out.println("Car is accelerating!");
    }

    @Override
    public void endMotion() {
        System.out.println("Car stopped moving!");
    }

    public void charli(){System.out.println("Vroom Vroom!");};
}
