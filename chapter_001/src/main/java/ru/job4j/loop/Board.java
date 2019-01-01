package ru.job4j.loop;

/**
 * @author anna brik
 * @version 1
 * @since 28.12.18
 */
public class Board {
    /**
     * @param width длина строки (ширина доски).
     * @param height количество строк(высота доски).
     * @return доска в виде строки.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((j + i) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
