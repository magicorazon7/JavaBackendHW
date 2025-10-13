import java.util.List;

public abstract class Vehicle implements Movable {

    public Vehicle(String name, int maxSpeed, List<Fuel> fuels, TransportCategory category){
        this.name = name;
        this.fuelTypes = List.copyOf(fuels);
        this.transportCategory = category;
        this.maxSpeed = maxSpeed;
    }
    
    public enum TransportCategory {
        land,
        air,
        water
    }
    
    public final List<Fuel> fuelTypes;
    public final TransportCategory transportCategory;
    public final int maxSpeed;
    public final String name;
    
}

