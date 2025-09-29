public sealed class landGasVehicle extends Vehicle permits Car, Motorcycle {
    public landGasVehicle(String name, int maxSpeed) {
        super(name, maxSpeed, FuelType.gasoline, TransportCategory.land);
    }
}
