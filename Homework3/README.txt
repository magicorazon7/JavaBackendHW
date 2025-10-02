Интерфейс Movable:
Определяет базовое поведение всех движущихся объектов: запуск двигателя, начало и конец движения.

Абстрактный sealed-класс Vehicle:
Имплементирует интерфейс Movable и задаёт общие свойства:
name — название транспорта;
maxSpeed — максимальная скорость;
fuelType — тип топлива (enum);
transportCategory — категория транспорта (enum);
Также реализует методы getInfo() и getMaxSpeed().

Перечисления (enum):
FuelType (gasoline, electric, diesel, jet, none);
TransportCategory (land, air, water).

Конкретные классы (наследники Vehicle):
GasCar;
ElectricCar;
FighterJet, имеет дополнительный метод по выполнению Пугачевской Кобры void doPugachevCobra();
Ship;
Motorcycle;
Car, имеет дополнительный метод void charli() по забавному созданию звука рева двигателя (отсылка к Charli XCX Vroom Vroom).

UML Диаграмма приложена к папке проекта (UMLdiagram.png)