public final class Ship extends Vehicle {
    public Ship(String name, int maxSpeed) {
        super(name, maxSpeed, FuelType.diesel, TransportCategory.water);
    }
}
