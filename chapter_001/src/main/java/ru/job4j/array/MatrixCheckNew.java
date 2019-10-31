package ru.job4j.array;

public class MatrixCheckNew {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int k = 0; k < board.length; k++) {
                char sign = board[k][k];
                if (sign == 'X') {
                    int x = 0;
                    int y = 0;
                    for (int n = 0; n < board.length; n++) {
                        if (board[k][n] == 'X') {
                            x++;
                        }
                        if (board[n][k] == 'X') {
                            y++;
                        }
                    }
                    if (x == 5 || y == 5) {
                        result = true;
                        break;
                    }
                }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }
}

/*
public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
            for (int cell = 0; cell < board.length; cell++) {
                char sign = board[row][cell];
                System.out.print(sign);
                //for () { проверить последовательность.
            }
            System.out.println();
        }
        return result;
    }

    for (int row = 0; row < board.length; row++) {
            for (int cell = 0; cell < board.length; cell++) {
                char sign = board[row][cell];
                System.out.print(sign);
                if (sign == 'X') {
                    for (int k = row, n = 0; k < board.length; k++) {
                        if (board[k][cell] == 'X') {
                            n++;
                        }
                    }
                }

            }
            System.out.println();
        }
 */