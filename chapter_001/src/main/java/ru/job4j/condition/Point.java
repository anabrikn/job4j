package ru.job4j.condition;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public double distance3D(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2) + Math.pow(this.z - that.z, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и Б: " + result);

        Point k = new Point(4, 1, 3);
        Point n = new Point(6, 2, 5);

        double result3d = k.distance3D(n);
        System.out.println("Расстояние между точками K и N: " + result3d);
        /*Point k = new Point(1, 1, 1);
        Point n = new Point(1, 3, 1);

        double result3d = k.distance3D(n);
        System.out.println("Расстояние между точками K и N: " + result3d);
         */
    }
}
