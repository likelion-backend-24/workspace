package day08;
// 추상 클래스
abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // 추상 메소드 (구현부가 없음)
    public abstract double getArea();
    public abstract double getPerimeter();

    // 일반 메소드
    public void displayColor() {
        System.out.println("색상: " + color);
    }
}

// 구체적인 클래스
 class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

 class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
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
public class Exam02 {
    public static void main(String[] args) {
        Shape s = new Circle("노랑",3);
        System.out.println(s.getArea());
        System.out.println(s.getPerimeter());

        Shape r = new Rectangle("검정",7,5);
        System.out.println(r.getArea());
        System.out.println(r.getPerimeter());

    }
}
