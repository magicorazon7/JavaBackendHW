import java.util.*;

public class VehicleInputScanner {
  private final Scanner scanner;
  
  public VehicleInputScanner() {
    this.scanner = new Scanner(System.in);
  }
  
  public Vehicle createVehicle() {
    int vehicleType = getVehicleType();
    String name = getVehicleName();
    int maxSpeed = getMaxSpeed();
    
    return createVehicleFromInput(vehicleType, name, maxSpeed);
  }
  
  private int getVehicleType() {
    while (true) {
      try {
        System.out.println("\n### Выберите тип транспорта ###");
        System.out.println("1 - Машина с бензиновым ДВС");
        System.out.println("2 - Электромобиль");
        System.out.println("3 - Транспорт");
        System.out.println("4 - Судно");
        System.out.println("5 - Гибридная машина");
        System.out.println("6 - Мотоцикл");
        System.out.print("Введите свой выбор - ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice < 1 || choice > 6) {
          throw new IllegalArgumentException("Неправильный выбор, введите число от 1 по 6");
        }
        
        return choice;
        
      } catch (InputMismatchException e) {
        System.err.println("Ошибка! Введите число");
        scanner.nextLine();
      } catch (IllegalArgumentException e) {
        System.err.println("Ошибка! " + e.getMessage());
      }
    }
  }
  
  private String getVehicleName() {
    while (true) {
      try {
        System.out.print("Введите имя транспорта: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
          throw new IllegalArgumentException("Поле имени транспорта не может быть пустым");
        }
        return name;
        
      } catch (IllegalArgumentException e) {
        System.err.println("Ошибка! " + e.getMessage());
      }
    }
  }
  
  private int getMaxSpeed() {
    while (true) {
      try {
        System.out.print("Введите максимальную скорость транспорта (км/ч): ");
        int speed = scanner.nextInt();
        scanner.nextLine();
        
        if (speed <= 0) {
          throw new IllegalArgumentException("Скорость должна быть положительной!");
        }

        return speed;
        
      } catch (InputMismatchException e) {
        System.err.println("Ошибка! Введите число");
        scanner.nextLine();
      } catch (IllegalArgumentException e) {
        System.err.println("Ошибка! " + e.getMessage());
      }
    }
  }
  
  private Vehicle createVehicleFromInput(int vehicleType, String name, int maxSpeed) {
    switch (vehicleType) {
      case 1:
        return new GasCar(name, maxSpeed);
      case 2:
        return new ElectricCar(name, maxSpeed);
      case 3:
        return new FighterJet(name, maxSpeed);
      case 4:
        return new Ship(name, maxSpeed);
      case 5:
        return new HybridCar(name, maxSpeed);
      case 6:
        return new Motorcycle(name, maxSpeed);
      default:
        throw new IllegalStateException("Недействительный тип транспорта " + vehicleType);
    }
  }
  
  public void close() {
    scanner.close();
  }
}
