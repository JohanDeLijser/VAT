package edu.tonnetje.vat.domain;

public class Sphere  extends Shape {
    private final double radius;
    final double PI = Math.PI;

    public Sphere() {
        this(1);
    }   
    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * Math.pow(radius, 2);
    }

    public double perimeter() {
        return 2 * PI * radius;
    }

    public double volume() {
    return -1;
    }
}
