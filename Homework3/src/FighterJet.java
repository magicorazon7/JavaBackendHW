import java.util.List;

public final class FighterJet extends Vehicle implements HasEngine {
    public FighterJet(String name, int maxSpeed) {
        super(name, maxSpeed, List.of(new JetFuel()), TransportCategory.air);
    }

    @Override
    public void startEngine() {
        System.out.println("Fighter jet's engines are running and heated, ready for flight!");
    }
    
    @Override
    public void stopEngine() {
    
    }
    
    @Override
    public void startMotion() {
        System.out.println("Fighter jet's increases altitude!");
    }

    @Override
    public void endMotion() {
        System.out.println("Fighter jet's landing gear is down!");
    }

    public void doPugachevsCobra() {
        System.out.println("Plane's AOA is 90 degrees!!!");
    }

}
