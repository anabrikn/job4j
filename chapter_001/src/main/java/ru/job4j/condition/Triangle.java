package ru.job4j.condition;
/**
 * @author anna brik
 * @version 1
 * @since 27.12.18
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Метод вычисления полупериметра по длинам сторон.
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2; // вместо -1 нужно написать формулу вычисляющую полупериметр.
    }
    /**
     * Метод должен вычислить площадь треугольника.
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1; // мы устанавливаем значение -1, так как может быть что треугольника нет. Это значение говорит о том. что треугольника нет.
        double ab = this.a.distance2D(this.b);
        double ac = this.a.distance2D(this.c);
        double bc = this.b.distance2D(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return булево значение, может ли существовать треугольник с такими координатами
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean value = false;
        if ((ab < ac + bc && ac < ab + bc && bc < ac + ab) && (ab != 0 && ac != 0 && bc != 0)) {
            value = true;
        }
        return value;
    }
}
