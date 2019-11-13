package ru.job4j.compare;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;

        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();

        int min = Math.min(left.length(), right.length());

        for (int i = 0; i < min; i++) {
            if (leftArr[i] != rightArr[i]) {
                return Character.compare(leftArr[i], rightArr[i]);
            }
        }

        if (left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "abcdefgh";
        System.out.println(a.compareTo(b));
    }
}