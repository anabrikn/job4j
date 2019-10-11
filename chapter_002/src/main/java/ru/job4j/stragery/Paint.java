package ru.job4j.stragery;

public class Paint {
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
