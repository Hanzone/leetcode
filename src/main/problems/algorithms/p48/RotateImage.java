package problems.algorithms.p48;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        rotateEdge(matrix, 0, matrix.length - 1);
    }

    private void rotateEdge(int[][] matrix, int from, int to) {
        if (from >= to) {
            return;
        }
        for (int i = 0; i < to - from; i++) {
            int temp = matrix[to - i][from];
            matrix[to - i][from] = matrix[to][to - i];
            matrix[to][to - i] = matrix[from + i][to];
            matrix[from + i][to] = matrix[from][from + i];
            matrix[from][from + i] = temp;
        }

        rotateEdge(matrix, from + 1, to - 1);
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix1 = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}};
        int[][] expect1 = {
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}};
        rotateImage.rotate(matrix1);
        printAnswerAndExpect(matrix1, expect1);

        int[][] matrix2 = {
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16}};
        int[][] expect2 = {
                new int[]{15, 13, 2, 5},
                new int[]{14, 3, 4, 1},
                new int[]{12, 6, 8, 9},
                new int[]{16, 7, 10, 11}};
        rotateImage.rotate(matrix2);
        printAnswerAndExpect(matrix2, expect2);

        int[][] matrix3 = {
                new int[]{2, 29, 20, 26, 16, 28},
                new int[]{12, 27, 9, 25, 13, 21},
                new int[]{32, 33, 32, 2, 28, 14},
                new int[]{13, 14, 32, 27, 22, 26},
                new int[]{33, 1, 20, 7, 21, 7},
                new int[]{4, 24, 1, 6, 32, 34}};
        int[][] expect3 = {
                new int[]{4, 33, 13, 32, 12, 2},
                new int[]{24, 1, 14, 33, 27, 29},
                new int[]{1, 20, 32, 32, 9, 20},
                new int[]{6, 7, 27, 2, 25, 26},
                new int[]{32, 21, 22, 28, 13, 16},
                new int[]{34, 7, 26, 14, 21, 28}};
        rotateImage.rotate(matrix3);
        printAnswerAndExpect(matrix3, expect3);

    }
}
