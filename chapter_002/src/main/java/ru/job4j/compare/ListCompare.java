package ru.job4j.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/*
Вы можете использовать

String.charAt(int index)
Integer.compare(int left, int right),
Character.compare(char left, char right);
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;

        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();

        int min = left.length() < right.length() ? left.length() : right.length();

        for (int i = 0; i < min; i++) {
            if (leftArr[i] != rightArr[i]) {
                return Character.compare(leftArr[i], rightArr[i]);
            }
        }

        if (left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length()); // left.length() > right.length() ? 1 : -1;
        }

        return result;
    }
}