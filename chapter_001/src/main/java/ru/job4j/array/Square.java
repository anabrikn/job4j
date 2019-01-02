package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0, i = 1; index < rst.length; index++, i ++) {
            rst[index] = (int)Math.pow(i, 2);
        }
        return rst;
    }
}
