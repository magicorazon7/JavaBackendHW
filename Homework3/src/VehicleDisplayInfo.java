import java.util.Arrays;
import java.util.stream.Collectors;

public class VehicleDisplayInfo {
  Vehicle vehicle;
  
  public VehicleDisplayInfo(Vehicle givenVehicle){
      this.vehicle = givenVehicle;
  }
  
  public void getVehicleName() {
    System.out.println("Vehicle name: " + vehicle.name);
  }
  
  public void getTransportType() {
    System.out.println("Transport type: " + vehicle.transportCategory);
  }
  
  public void getMaxSpeed() {
    System.out.println("Max speed: "+vehicle.maxSpeed+" km/h");
  }
  
  public void getFuelType() {
    String fuelNames = vehicle.fuelTypes.stream()//перевод в стрим
    .map(Fuel::getTypeName)
    .collect(Collectors.joining(" + "));
    System.out.println("Fuel type: " + fuelNames);
  }
  
}
