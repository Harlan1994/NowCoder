package seclab.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Harlan1994
 * Date: 2017/9/2
 * Time: 12:43
 * Description:
 */
public class B11172 {

    /**
     * 一圈一圈递归打印
     *
     * @param left
     * @param right
     * @param top
     * @param bottom
     * @param matrix
     * @param array
     */
    public static void matrixToArray(int left, int right, int top, int bottom, int[][] matrix, List<Integer> array) {
        if (!(left <= right && top <= bottom)) return;

        for (int i = left; i <= right; i++) {
            array.add(matrix[top][i]);
        }

        for (int i = top + 1; i <= bottom; i++) {
            array.add(matrix[i][right]);
        }

        // 避免单行单列情况出错，需要加判断防止重复添加。
        if (top != bottom) {
            for (int i = right - 1; i >= left; --i) {
                array.add(matrix[bottom][i]);
            }
        }
        // 避免单行单列情况出错，需要加判断防止重复添加。
        if (left != right) {
            for (int i = bottom - 1; i > top; --i) {
                array.add(matrix[i][left]);
            }
        }

        matrixToArray(left + 1, right - 1, top + 1, bottom - 1, matrix, array);
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> array = new ArrayList<>();
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        matrixToArray(left, right, top, bottom, matrix, array);
        return array;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        ArrayList<Integer> matrix = printMatrix(array);

        for (Integer integer : matrix) {
            System.out.print(" " + integer);
        }
    }
}