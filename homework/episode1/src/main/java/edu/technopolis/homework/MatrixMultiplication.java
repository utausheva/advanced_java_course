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
public class MatrixMultiplication {
     static void Multi(int[][] a, int[][] b) {

        int[][] res = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String... args) throws Throwable {
        Scanner sc = new Scanner(System.in);

        //Считывание размерностей матриц
        try {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (n <= 0 || m <= 0 || x <= 0 || y <= 0)
                throw new IOException("Неправильно введены размерности массивов!");
            if (m != x)
                throw new SingularMatrixException("Не перемножить матрицы, поскольку размерности не соотносятся");


            //Инициализация матриц
            int[][] a = new int[n][m];
            int[][] b = new int[x][y];

            //Считывание первой матрицы
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            //Считывание второй матрицы
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    b[i][j] = sc.nextInt();
                }
            }

            Multi(a, b);

        } catch (InputMismatchException e) {
            System.out.println("Размерность матрицы - не число!");
        }
    }
}
