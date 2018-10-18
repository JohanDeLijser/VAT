package edu.tonnetje.vat.domain;

public class Cube extends Shape {
	private final double width, length, height;

	public Cube() {
		this(1,1,1);
	}
	public Cube(double width, double length, double height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}

	@Override
	public double area() {
		return width * length;
	}

	public double perimeter() {
		return 2 * (width + length);
	}

	@Override
	public double volume() {
		return length * width * height;


	}
}
