public final class Motorcycle extends Vehicle {
    public Motorcycle(String name, int maxSpeed) {
        super(name, maxSpeed, FuelType.gasoline, TransportCategory.land);
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
