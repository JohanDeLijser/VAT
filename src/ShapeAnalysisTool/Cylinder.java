package ShapeAnalysisTool;

public class Cylinder {

    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getVolume() {
        return  Math.PI * (this.radius * this.radius) * this.height;
    }
}
