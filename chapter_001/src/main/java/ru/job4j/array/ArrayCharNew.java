package ru.job4j.array;

public class ArrayCharNew {
    public static boolean startWith(char[] word, char[] pref) {
        boolean result = false;
        for (int i = 0; i < pref.length; i++) {
            result = true;
            if (word[i] != pref[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
