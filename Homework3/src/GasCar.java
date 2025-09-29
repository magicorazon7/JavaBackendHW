public final class GasCar extends Vehicle {
    public GasCar (String name, int maxSpeed){
        super(name, maxSpeed, FuelType.gasoline, TransportCategory.land);
    }
}
