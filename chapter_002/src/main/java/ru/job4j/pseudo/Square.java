package ru.job4j.pseudo;

/**
 * @author anna brik
 * @version 1
 * @since 01.05.19
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder()
            .append("+++++++")
            .append("\n")
            .append("+     +")
            .append("\n")
            .append("+     +")
            .append("\n")
            .append("+++++++");
        return sb.toString();
    }
}
