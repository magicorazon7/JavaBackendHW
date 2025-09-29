public abstract sealed class Vehicle permits GasCar, ElectricCar, FigherJet, Ship, Motorcycle {

    public Vehicle(String name, int maxSpeed, FuelType fuel, TransportCategory category){
        this.name = name;
        this.fuelType = fuel;
        this.transportCategory = category;
        this.maxSpeed = maxSpeed;
    }

    public enum FuelType {
        gasoline,
        electric,
        diesel,
        jet,
        none;
    }

    public enum TransportCategory {
        land,
        air,
        water
    }

    private final FuelType fuelType;
    private final TransportCategory transportCategory;
    private final int maxSpeed;
    private final String name;

    public String start() {
        return "Vehicle " + name + " started";
    }

    public String getInfo() {
        return "Vehicle name: " + name + "\n" +"Transport type: " + transportCategory +
                "\n" + "Fuel type: " + fuelType;
    }

    public String getMaxSpeed() {
        return "Vehicle " + name + " has maximum speed of "+ maxSpeed +" km/h";
    }
}

