package ru.geekbrains.javaone.lesson2;

import java.util.Arrays;

public class HW2 {

    public static void main(String[] args) {
        zadacha1();
        System.out.println();

        zadacha2();
        System.out.println();


        zadacha3();
        System.out.println();


        zadacha4();
        System.out.println();

        zadacha5();
        System.out.println();

        zadacha6();
        

    }

    /*1 Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    public static void zadacha1() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(change(arr)));

    }

    private static int[] change(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
                default:
                    continue;
            }

        }
        return arr;
    }


    /*2 Задать пустой целочисленный массив размером 8.
    Написать метод, который помощью цикла
    заполнит его значениями 1 4 7 10 13 16 19 22;
     */
    public static void zadacha2() {
        int[] arr = new int[8];

        inflate(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void inflate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3 + 1;
        }
    }


    /*3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    написать метод, принимающий на вход массив
    и умножающий числа меньше 6 на 2;
     */

    public static void zadacha3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        multiplication(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void multiplication(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;

            }
        }
    }


    /*4 Задать одномерный массив. Написать методы поиска
    в нём минимального и максимального элемента;
     */
    public static void zadacha4() {
        int[] arr = {1, 5, 205, 30, 51, -8};
        int[] result = findMinMax(arr);

        System.out.print("Минимальное число: " + result[0] + " Максимальное число: " + result[1]);
    }

    private static int[] findMinMax(int[] arr) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }


    /*5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
     заполнить его диагональные элементы единицами, используя цикл(ы);
      */
    public static void zadacha5() {
        int n = 5;
        int[][] arr = new int[n][n];
        setDiagonals(n, arr);
        printArray(n, arr);

    }

    private static void printArray(int n, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void setDiagonals(int n, int[][] arr) {
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
            arr[n - 1 - i][i] = 1;

        }
    }


    /*6 ** Написать метод, в который передается
    не пустой одномерный целочисленный массив,
    метод должен вернуть true если в массиве есть место,
    в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, || 2, 1]) →
    true, checkBalance ([2, 1, 1, 2, 1]) → false,
    checkBalance ([10, || 1, 2, 3, 4]) → true.
    Абстрактная граница показана символами ||,
    эти символы в массив не входят.
     */
    public static void zadacha6() {
        int[] arr = {1, 1, 1, 2, 1};
//        int[] arr = {10, 1, 2, 3, 4};
//        int[] arr = {2, 1, 1, 2, 1};
        System.out.println(checkBalance(arr));

    }

    private static boolean checkBalance(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;

        int leftPosition = 0;
        int rightPosition = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                leftSum += arr[i];
                rightSum += arr[arr.length - 1];
            } else {
                if (leftPosition + 1 == rightPosition) {
                    break;
                }
                if (leftSum > rightSum) {
                    rightPosition--;
                    rightSum += arr[rightPosition];
                } else {
                    leftPosition++;
                    leftSum += arr[leftPosition];
                }
            }


        }
        return leftSum == rightSum;
    }


}
