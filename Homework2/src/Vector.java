final class Vector {

    public final double X;
    public final double Y;
    public final double Z;

    public Vector(double x, double y, double z) {
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    public double calcLength(){
        return Math.sqrt(X * X + Y * Y + Z*Z);
    }

    public double calcScalarProd(Vector vector){
        return X * vector.X + Y * vector.Y + Z * vector.Z;
    }

    public Vector calcCrossProd(Vector vector){
        double iAxis = Y * vector.Z - Z * vector.Y;
        double jAxis = Z * vector.X - X * vector.Z;
        double kAxis = X * vector.Y - Y * vector.X;

        return new Vector(iAxis,jAxis,kAxis);
    }

    public double calcAngle(Vector vector){
        double numerator = this.calcScalarProd(vector);
        double denumerator = this.calcLength()*vector.calcLength();
        double cosTheta = 0;

        if (denumerator == 0) {
            throw new IllegalArgumentException("Zero vector, angle calculation not possible");
        }

        cosTheta = numerator / denumerator;

        return Math.acos(cosTheta);
    }

    public Vector subtract(Vector vector){
        return new Vector(X - vector.X, Y - vector.Y, Z - vector.Z);
    }

    public Vector subtract(double num){
        return new Vector(X -num, Y - num, Z - num);

    }

    public Vector sum(Vector vector){
        return new Vector(X+vector.X,Y+vector.Y,Z+vector.Z);
    }

    public Vector sum(double num){
        return new Vector(X+num,Y+num,Z+num);
    }

    public static Vector[] generateRandomVectors(int N) {
        Vector[] vectors = new Vector[N];
        for (int i = 0; i < N; i++) {
            double x = Math.random() * 5;
            double y = Math.random() * 5;
            double z = Math.random() * 5;
            vectors[i] = new Vector(x, y, z);
        }
        return vectors;
    }

}
