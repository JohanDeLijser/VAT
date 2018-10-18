package ShapeAnalysisTool.shape;

public class Sphere {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return (4 / 3) * Math.PI * (this.radius * this.radius);
    }
}
