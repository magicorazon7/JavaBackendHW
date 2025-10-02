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
GasCar - машина с ДВС, имеет дополнительный метод void charli() для забавного звука рева двигателя (отсылка к Charli XCX Vroom Vroom).
ElectricCar - электрокар;
FighterJet - истребитель, имеет дополнительный метод по выполнению Пугачевской Кобры void doPugachevCobra();
Ship - корабль;
Motorcycle - мотоцикл.


UML Диаграмма приложена к папке проекта (UMLdiagram.png)
