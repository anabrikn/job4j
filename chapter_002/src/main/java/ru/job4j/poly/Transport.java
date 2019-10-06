package ru.job4j.poly;

public interface Transport {
    public void drive();
    public void pass(Passenger[] passengers);
    public double refill(double quantity);
}
