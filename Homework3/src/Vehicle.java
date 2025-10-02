public abstract sealed class Vehicle implements Movable permits GasCar, ElectricCar, FighterJet, Ship, Motorcycle {

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

    public final FuelType fuelType;
    public final TransportCategory transportCategory;
    public final int maxSpeed;
    public final String name;

    public void getInfo() {
        System.out.println("Vehicle name: " + name + "\n" +"Transport type: " + transportCategory +
                "\n" + "Fuel type: " + fuelType);
    }

    public void getMaxSpeed() {
        System.out.println("Vehicle " + name + " has maximum speed of "+ maxSpeed +" km/h");
    }
}

