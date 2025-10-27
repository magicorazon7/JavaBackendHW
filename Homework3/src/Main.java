
public class Main {
    public static void main(String[] args) {
        
        VehicleInputScanner newVehicle = new VehicleInputScanner();
        Vehicle testVehicle = newVehicle.createVehicle();
    
        VehicleDisplayInfo display = new VehicleDisplayInfo(testVehicle);
        display.getFuelType();
        display.getMaxSpeed();
        display.getTransportType();
        display.getVehicleName();
    
    }
    
}