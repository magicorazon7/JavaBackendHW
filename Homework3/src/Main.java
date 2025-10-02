
public class Main {
    public static void main(String[] args) {
        ElectricCar EV = new ElectricCar("Tesla model 3",200);
        EV.getInfo();
        EV.startEngine();
        EV.startMotion();
        EV.endMotion();
        EV.getMaxSpeed();

        Motorcycle someSuzuki = new Motorcycle("GSX-R100",280);
        someSuzuki.getInfo();
        someSuzuki.startEngine();
        someSuzuki.startMotion();
        someSuzuki.endMotion();
        someSuzuki.getMaxSpeed();

        Ship DemyanBedniy = new Ship("Q-065",30);
        DemyanBedniy.getInfo();
        DemyanBedniy.startEngine();
        DemyanBedniy.startMotion();
        DemyanBedniy.endMotion();
        DemyanBedniy.getMaxSpeed();

        FigherJet suJet = new FigherJet("SU-27M",2400);
        suJet.getInfo();
        suJet.startEngine();
        suJet.startMotion();
        suJet.endMotion();
        suJet.getMaxSpeed();

        GasCar jeep = new GasCar("Land Cruiser Prado",160);
        jeep.getInfo();
        jeep.startEngine();
        jeep.startMotion();
        jeep.endMotion();
        jeep.getMaxSpeed();
    }
}