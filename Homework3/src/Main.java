
public class Main {
    public static void main(String[] args) {
        GasCar jeep = new GasCar("Land Cruiser Prado",160);
        jeep.startEngine();
        jeep.startMotion();
        jeep.endMotion();
        jeep.charli();
        
        VehicleDisplayInfo display = new VehicleDisplayInfo(jeep);
        display.getFuelType();
        display.getMaxSpeed();
        display.getTransportType();
        display.getVehicleName();
        
        HybridCar Prius = new HybridCar("Toyota Prius 2010",20000);
        Prius.startEngine();
        Prius.startMotion();
        Prius.endMotion();
        Prius.legendaryPrius();
        
        VehicleDisplayInfo displaySecond = new VehicleDisplayInfo(Prius);
        displaySecond.getFuelType();
        displaySecond.getMaxSpeed();
        displaySecond.getTransportType();
        displaySecond.getVehicleName();
        
    }
    
}