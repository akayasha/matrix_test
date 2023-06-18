package org.example.apps;

import java.util.Random;

public class MatrixApplication {
    public static void main(String[] args) {
        int width = 25;
        int height = 15;
        char[][] matrix = generateMatrix(width, height);
        markPlus(matrix);
        printMatrix(matrix);

        String answer = findAnswer(matrix);
        System.out.println("\nJawaban: " + answer);
    }

    public static char[][] generateMatrix(int width, int height) {
        char[][] matrix = new char[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int randomValue = random.nextInt(2);
                matrix[i][j] = (randomValue == 1) ? '1' : '0';
            }
        }

        return matrix;
    }

    public static void markPlus(char[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;

        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (matrix[i][j] == '1') {
                    // Check if the surrounding elements form a plus shape
                    if (matrix[i - 1][j] == '1' && matrix[i + 1][j] == '1' &&
                            matrix[i][j - 1] == '1' && matrix[i][j + 1] == '1') {
                        // Mark the plus shape with '*'
                        matrix[i][j] = '*';
                        matrix[i - 1][j] = '*';
                        matrix[i + 1][j] = '*';
                        matrix[i][j - 1] = '*';
                        matrix[i][j + 1] = '*';
                    }
                }
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public static String findAnswer(char[][] matrix) {
        StringBuilder answer = new StringBuilder();
        int width = matrix[0].length;
        int height = matrix.length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '*') {
                    answer.append("(").append(j).append(",").append(i).append(")\n");
                }
            }
        }

        return answer.toString();
    }
}
