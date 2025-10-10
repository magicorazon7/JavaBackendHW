public final class Ship extends Vehicle {
    public Ship(String name, int maxSpeed) {
        super(name, maxSpeed, FuelType.diesel, TransportCategory.water);
    }

    @Override
    public void startEngine() {
        System.out.println("Ship's engines are running!");
    }
    
    @Override
    public void stopEngine() {
    
    }
    
    @Override
    public void startMotion() {
        System.out.println("Ship's leaving a harbor!");
    }

    @Override
    public void endMotion() {
        System.out.println("Ship's stopped!");
    }
}
