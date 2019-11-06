package ru.geekbrains.javaone.lesson3;


import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] field;
    private static final int fieldSizeX = 5;
    private static final int fieldSizeY = 5;
    private static final int charactersToWin = 4;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';

    public static void main(String[] args) {
        initField();
        showField();
        while (true) {
            humanTurn();
            showField();
            if (checkWinNew(DOT_HUMAN)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            showField();
            if (checkWinNew(DOT_AI)) {
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }

    }

    private static void initField() {
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void showField() {
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print("|");

            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.printf("Введите координаты X и Y (от 1 до %d) через %s>>> ", fieldSizeX, "пробел");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }
    private static boolean isEmptyCellForPadla(int x, int y) {
        return isValidCell(x,y) && field[x][y] == DOT_EMPTY;
    }

    private static void aiTurn() {
        int x;
        int y;
        PredictedPoint pp = aiPadla(DOT_HUMAN);
        if (pp.isPredicted()) {
            System.out.println("Компьтер выбрал predicted ячейку " + (pp.y + 1) + " " + (pp.x + 1));
            field[pp.x][pp.y] = DOT_AI;
        } else {
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(x, y));

            System.out.println("Компьтер выбрал ячейку " + (x + 1) + " " + (y + 1));
            field[y][x] = DOT_AI;

        }

    }

    private static PredictedPoint aiPadla(char c) {
        int count = 0;

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == c) {
                    count++;
                } else {
                    count = 0;
                }

                if (count == charactersToWin - 1) {
                    if (isEmptyCellForPadla(i, j + 1)) {
                        return new PredictedPoint(i, j + 1);
                    }

                }
            }
            count = 0;
        }
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[j][i] == c) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == charactersToWin - 1) {
                    if (isEmptyCellForPadla(j + 1, i)) {
                        return new PredictedPoint(j + 1, i);
                    }

                }
            }
            count = 0;
        }

        int countD = 0;
        for (int i = 0; i < fieldSizeX; i++) {
            if (field[i][i] == c) {
                count++;
            } else {
                count = 0;
            }
            if (field[fieldSizeX - 1 - i][i] == c) {
                countD++;
            } else {
                countD = 0;
            }
            if (count == charactersToWin - 1) {
                if (isEmptyCellForPadla(i + 1, i + 1)) {
                    return new PredictedPoint(i + 1, i + 1);
                }
            }
            if (countD == charactersToWin - 1) {
                if (isEmptyCellForPadla(fieldSizeX - 2 - i, i + 1)) {
                    return new PredictedPoint(fieldSizeX - 2 - i, i + 1);
                }
            }
        }
        return new PredictedPoint(-1, -1);
    }

    private static boolean checkWinNew(char c) {
        int count = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == c) {
                    count++;
                } else {
                    count = 0;
                }

                if (count == charactersToWin) {
                    return true;
                }
            }
            count = 0;
        }
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[j][i] == c) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == charactersToWin) {
                    return true;
                }
            }
            count = 0;
        }

        int countD = 0;
        for (int i = 0; i < fieldSizeX; i++) {
            if (field[i][i] == c) {
                count++;
            } else {
                count = 0;
            }
            if (field[fieldSizeX - 1 - i][i] == c) {
                countD++;
            } else {
                countD = 0;
            }
            if (count == charactersToWin || countD == charactersToWin) {
                return true;
            }
        }
        return false;
    }


    private static boolean isDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    return false;
                }

            }
        }
        return true;
    }



    static class PredictedPoint {
        int x;
        int y;

        public PredictedPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public boolean isPredicted() {
            return x > -1 && y > -1;

        }
    }
}
