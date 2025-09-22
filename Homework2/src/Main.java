//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vector Vector1 = new Vector(1,2,3);
        Vector Vector2 = new Vector(2,3,7);
        double lenght = Vector1.calcLength();
        System.out.println("The length of Vector1 is: " + lenght+"\n");

        double scalarProduct = Vector1.calcScalarProd(Vector2);
        System.out.println("the scalar product of Vector1 and Vector2 is " + scalarProduct +"\n");

        double angle = Vector1.calcAngle(Vector2);
        System.out.println("the angle between Vector1 and Vector2 is " + angle+ " rad" +"\n");

        Vector dotProduct = Vector1.calcCrossProd(Vector2);
        System.out.println("the inner product of Vector1 and Vector2 is Vector12 with XYZ coordinates:" +
                dotProduct.X+" "+dotProduct.Y+" "+dotProduct.Z+"\n");

        Vector subVector = Vector2.subtract(Vector1);

        System.out.println("Vector2 - Vector1 is Vector with XYZ coordinates: " +
                subVector.X+" "+subVector.Y+" "+subVector.Z+"\n");


        Vector sumVector = Vector2.sum(Vector1);

        System.out.println("Vector2 + Vector1 is Vector with XYZ coordinates: " +
                sumVector.X+" "+sumVector.Y+" "+sumVector.Z+"\n");


        Vector[] testRandom = Vector.generateRandomVectors(1);

        System.out.println("A random vector has been created! With XYZ coordinates: " +
                testRandom[0].X+" "+testRandom[0].Y+" "+testRandom[0].Z+"\n");

    }
}