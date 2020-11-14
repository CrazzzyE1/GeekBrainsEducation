package com.company.lesson4;

import java.util.Scanner;

public class XOGame {
    private static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static int x = -1, y = -1;
    public static final char DOT_EMPTY = '_';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {

            humanMove();
            if (checkWin(DOT_X)) {
                System.out.println("Вы победили...");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья...");
                break;
            }
            aiMove();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил...");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья...");
                break;
            }
        }
        System.out.println("Игра окончена!!!");

    }

    private static boolean checkWin(char symbol) {
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;

        //Проверка вертикалей, горизонталей и основный диагоналей
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            int count2 = 0;
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == symbol) {
                        count3++;
                    } else {
                        count3 = 0;
                    }
                    if (map[i][SIZE - j - 1] == symbol) {
                        count4++;
                    } else {
                        count4 = 0;
                    }
                }

                if (map[i][j] == symbol) {
                    count++;
                } else {
                    count = 0;
                }
                if (map[j][i] == symbol) {
                    count2++;
                } else {
                    count2 = 0;
                }


                if (count == DOTS_TO_WIN || count2 == DOTS_TO_WIN || count3 == DOTS_TO_WIN || count4 == DOTS_TO_WIN)
                    return true;
            }
        }

        // Проверка субдиагоналей, если DOTS_TO_WIN < SIZE
        // (Условие нужно только потому, что меняем размер поля руками в коде)

        if (DOTS_TO_WIN < SIZE) {
            for (int i = 0; i < SIZE - 1; i++) {
                if (map[i][i + 1] == symbol) {
                    count5++;
                } else {
                    count5 = 0;
                }
                if (map[i + 1][i] == symbol) {
                    count6++;
                } else {
                    count6 = 0;
                }

                if (map[SIZE - i - 2][i] == symbol) {
                    count7++;
                } else {
                    count7 = 0;
                }
                if (map[SIZE - 1 - i][i + 1] == symbol) {
                    count8++;
                } else {
                    count8 = 0;
                }

                if (count5 == DOTS_TO_WIN || count6 == DOTS_TO_WIN || count7 == DOTS_TO_WIN || count8 == DOTS_TO_WIN)
                    return true;
            }
        }

        return false;
    }

    private static int aiCheckBestPosition() {
        int max = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            int count2 = 0;
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == DOT_X) {
                        count3++;
                    } else {
                        count3 = 0;
                    }
                    if (map[i][SIZE - j - 1] == DOT_X) {
                        count4++;
                    } else {
                        count4 = 0;
                    }
                }

                if (map[i][j] == DOT_X) {
                    count++;
                } else {
                    count = 0;
                }
                if (map[j][i] == DOT_X) {
                    count2++;
                } else {
                    count2 = 0;
                }

                if (max < count) max = count;
                if (max < count2) max = count2;
                if (max < count3) max = count3;
                if (max < count4) max = count4;

            }
        }

        // Проверка субдиагоналей, если DOTS_TO_WIN < SIZE
        // (Условие нужно только потому, что меняем размер поля руками в коде)
        if (DOTS_TO_WIN < SIZE) {
            for (int i = 0; i < SIZE - 1; i++) {
                if (map[i][i + 1] == DOT_X) {
                    count5++;
                } else {
                    count5 = 0;
                }
                if (map[i + 1][i] == DOT_X) {
                    count6++;
                } else {
                    count6 = 0;
                }

                if (map[SIZE - i - 2][i] == DOT_X) {
                    count7++;
                } else {
                    count7 = 0;
                }
                if (map[SIZE - 1 - i][i + 1] == DOT_X) {
                    count8++;
                } else {
                    count8 = 0;
                }

                if (max < count5) max = count5;
                if (max < count6) max = count6;
                if (max < count7) max = count7;
                if (max < count8) max = count8;
            }
        }

        return max;
    }

    private static boolean isFullMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static void aiMove() {
        System.out.println("Ход компьютера...");

        //Ai занимает центральную ячейку на первом ходу, если она свободна
        if (map[SIZE / 2][SIZE / 2] == DOT_EMPTY && isValid(SIZE / 2, SIZE / 2)) {
            map[SIZE / 2][SIZE / 2] = DOT_O;
            printMap();
            return;
        }

        // Ai жаждит выиграть и ищет ячейку для быстрой победы.
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        printMap();
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        // Ai высчитывает следующий выгодный ход для человека и пытается его блокировать.
        int bestPosCount = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (bestPosCount < aiCheckBestPosition()) {
                        bestPosCount = aiCheckBestPosition();
                        x = i;
                        y = j;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        if (isValid(x, y)) {
            map[x][y] = DOT_O;
        }

        printMap();
    }


    public static boolean isValid(int x, int y) {
        return map[x][y] == DOT_EMPTY;
    }


    public static void humanMove() {
        System.out.println("Ваш ход. Введите X и Y...");

        while (true) {
            try {

                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;

                if (isValid(x, y)) {
                    map[x][y] = DOT_X;
                } else {
                    System.out.println("Позиция занята, введите новые значения:");
                    continue;
                }

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Введите корректные значения X и Y от 1 до " + SIZE + ":");
                continue;
            }
            printMap();
            break;
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}


