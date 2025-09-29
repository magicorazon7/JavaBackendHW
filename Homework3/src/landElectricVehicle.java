public sealed class landElectricVehicle extends Vehicle permits electricCar {
    public landElectricVehicle(String name, int maxSpeed) {
        super(name, maxSpeed, FuelType.electric, TransportCategory.land);
    }
}
