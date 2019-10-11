package ru.job4j.stragery;

public class Triangle implements Shape {
    @Override
    public String draw() {
        return new StringBuilder()
                .append("   +   ")
                .append("\n")
                .append("  + +  ")
                .append("\n")
                .append(" +   + ")
                .append("\n")
                .append("+++++++").toString();
    }
}
