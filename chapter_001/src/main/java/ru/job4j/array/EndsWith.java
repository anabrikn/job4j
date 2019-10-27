package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        int index = word.length - post.length;
        for (int i = post.length - 1; i >= 0; i--) {
            result = true;
            if (word[index + i] != post[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
