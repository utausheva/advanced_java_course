package edu.technopolis.homework;

import com.sun.javafx.geom.transform.SingularMatrixException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MultiMatrix {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner(System.in);
        System.out.println("Программа считает произведение матриц.");
        System.out.println("Введите размерности матриц и матрицы в формате:");
        System.out.println("N M X Y A_1_1 ... A_N_M B_1_1 ... B_X_Y");
        System.out.println("где N и M - размерность первой матрицы A (количество строк и столбцов),");
        System.out.println("A_1_1 ... A_N_M - элементы матрицы A, ");
        System.out.println(" X и Y - размерность второй матрицы B,");
        System.out.println("B_1_1 ... B_X_Y - элементы матрицы B.");

        //Считывание размерностей матриц
        try {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            boolean flag = false;
            while (!flag) {
                if (n <= 0 || m <= 0 || x <= 0 || y <= 0) {
                    // throw new IOException("Неправильно введены размерности массивов!");
                    System.out.println("Размерности - положительные целые числа!");
                    n = sc.nextInt();
                    m = sc.nextInt();
                    x = sc.nextInt();
                    y = sc.nextInt();
                } else flag = true;
                if (m != x) {
                    //throw new SingularMatrixException("Не перемножить матрицы, поскольку размерности не соотносятся");
                    System.out.println("Не перемножить матрицы, поскольку размерности не соотносятся (введите m==x)");
                    System.out.println("Заново повторите ввод размерностей:");
                    n = sc.nextInt();
                    m = sc.nextInt();
                    x = sc.nextInt();
                    y = sc.nextInt();
                } else flag = true;
            }
            //Инициализация матриц
            int[][] a = new int[n][m];
            int[][] b = new int[x][y];

            //Считывание первой матрицы
            System.out.println("Введите " + n*m + " чисел первой матрицы");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            //Считывание второй матрицы
            System.out.println("Введите " + x*y + " чисел второй матрицы");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    b[i][j] = sc.nextInt();
                }
            }

            int[][]res= new int[n][y];

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        res[i][j] += a[i][k] * b[k][j];
                    }
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }

        } catch (InputMismatchException e) {
            System.out.println("Размерность матрицы - не число, либо дробное число!");
        }
    }
}
