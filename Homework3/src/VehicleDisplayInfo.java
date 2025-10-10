public class VehicleDisplayInfo {
  Vehicle vehicle;
  
  public VehicleDisplayInfo(Vehicle givenVehicle){
      this.vehicle = givenVehicle;

  }
  
  public void getInfo() {
    System.out.println("Vehicle name: " + vehicle.name + "\n" +"Transport type: " + vehicle.transportCategory +
    "\n" + "Fuel type: " + vehicle.fuelType+"Max speed: "+vehicle.maxSpeed+" km/h");
  }
  
}
