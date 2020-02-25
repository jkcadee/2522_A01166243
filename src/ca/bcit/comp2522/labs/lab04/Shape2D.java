package ca.bcit.comp2522.labs.lab04;

public abstract class Shape2D {
    public static final double PI = 3.141592535;
    public abstract void draw();
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Rectangle extends Shape2D{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle.");
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

class Circle extends Shape2D{
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle.");
    }

    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}

abstract class Polygon extends Shape2D{
    protected int numberOfSides;
    public Polygon(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
}

class RegularPolygon extends Polygon {
    public int length;
    public double apothem;

    public RegularPolygon(int length, double apothem, int numberOfSides) {
        super(numberOfSides);
        this.length = length;
        this.apothem = apothem;
    }

    @Override
    public void draw() {
        System.out.println("Drawing RegularPolygon.");
    }

    @Override
    public double getArea() {
        return length * numberOfSides;
    }

    @Override
    public double getPerimeter() {
        return 0.5 * apothem;
    }
}



