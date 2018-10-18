package ShapeAnalysisTool;

public class Cube {

    private double length;
    private double width;
    private double height;

    public Cube(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return this.length * this.width * this.height;
    }
}
