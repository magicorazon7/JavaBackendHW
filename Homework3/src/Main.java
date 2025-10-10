
public class Main {
    public static void main(String[] args) {
        ElectricCar EV = new ElectricCar("Tesla model 3",200);
        EV.startEngine();
        EV.startMotion();
        EV.endMotion();

        Motorcycle someSuzuki = new Motorcycle("GSX-R100",280);
        someSuzuki.startEngine();
        someSuzuki.startMotion();
        someSuzuki.endMotion();

        Ship DemyanBedniy = new Ship("Q-065",30);
        DemyanBedniy.startEngine();
        DemyanBedniy.startMotion();
        DemyanBedniy.endMotion();

        FighterJet suJet = new FighterJet("SU-27M",2400);
        suJet.startEngine();
        suJet.startMotion();
        suJet.endMotion();
        suJet.doPugachevsCobra();

        GasCar jeep = new GasCar("Land Cruiser Prado",160);
        jeep.startEngine();
        jeep.startMotion();
        jeep.endMotion();
        jeep.charli();
    }
}