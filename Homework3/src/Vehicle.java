public abstract class Vehicle {

    public Vehicle(String name, FuelType fuel, TransportCategory category, EngineType engine){
        this.name = name;
        this.fuelType = fuel;
        this.engineType = engine;
        this.transportCategory = category;
    }

    public enum FuelType {
        gasoline,
        diesel,
        electric,
        coal,
        none;
    }
    public enum TransportCategory {
        land,
        air,
        water
    }
    public enum EngineType {
        internalCombustion,
        jet,
        electric,
        non
    }

    private final FuelType fuelType;
    private final EngineType engineType;
    private final TransportCategory transportCategory;
    private final String name;

    public String start() {
        return "Vehicle " + name + " started";
    }

    public String getInfo() {
        return "Vehicle name: " + name + "\n" +"Transport type: " + transportCategory +
                "\n" + "Fuel type: " + fuelType + "Engine type: "  + "\n" + engineType;
    }

    public abstract int getMaxSpeed();
}

