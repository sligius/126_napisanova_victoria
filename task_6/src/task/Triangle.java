package task;

public class Triangle {
    private double A;
    private double B;
    private double C;

    public Triangle (double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double getA(){
        return A;
    }
    public double getB(){
        return B;
    }
    public double getC(){
        return C;
    }
    public boolean isValid() {
        return (A + B > C && A + C > B && B + C > A);
    }
    public double square() {
        double p = (A + B + C) / 2;
        if (isValid()) {
            return Math.sqrt(p * (p - A) * (p - B) * (p - C));
        }
        else {
            return -1;
        }
    }
    public double perimeter(){
        if(isValid())
            return A + B + C;
        else
            return -1;
    }
}
