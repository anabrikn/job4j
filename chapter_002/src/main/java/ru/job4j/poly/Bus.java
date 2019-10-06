package ru.job4j.poly;

public class Bus implements Transport {
    private Passenger[] passengers;
    private double fuel = 0;
    private double price = 46.70;

    @Override
    public void drive() {
        System.out.println("Дрын-дрын-дрын");
    }

    @Override
    public void pass(Passenger[] pass) {
        this.passengers = pass;
    }

    @Override
    public double refill(double quantity) {
        this.fuel = fuel + quantity;
        return quantity * price;
    }
}
