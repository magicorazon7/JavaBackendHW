public final class ElectricCar extends Vehicle {
    public ElectricCar(String name, int maxSpeed) {
        super(name, maxSpeed, FuelType.electric, TransportCategory.land);
    }
}
