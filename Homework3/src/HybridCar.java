import java.util.List;

public class HybridCar extends Vehicle implements HasEngine{
  public HybridCar (String name, int maxSpeed){
    super(name, maxSpeed, List.of(new GasolineFuel(), new ElectricFuel()), TransportCategory.land);
  }
  
  @Override
  public void startEngine() {
    System.out.println("Car's engine started!");
  }
  
  @Override
  public void stopEngine() {}
  
  @Override
  public void startMotion() {
    System.out.println("Car is accelerating!");
  }
  
  @Override
  public void endMotion() {
    System.out.println("Car stopped moving!");
  }
  
  
  public void legendaryPrius(){System.out.println("На Приусе расход вообще нулевой");};
}
