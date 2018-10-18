package edu.tonnetje.vat.domain;

public class Cylinder  extends Shape {
	private final double radius, height;
	final double PI = Math.PI;

	public Cylinder() {
		this(1,1);
	}   
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
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
