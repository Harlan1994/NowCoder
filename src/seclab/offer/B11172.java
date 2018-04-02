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

        /**
         * 其实每次从左往右肯定是不会重复的，从上到下也不会，因为横坐标每次都会加上1
         * 但是从右往左，有可能就会重复了，因为只是纵坐标加上了1，但是可能往回走的时候
         * 依然是同一行的元素
         *
         * 比如 只有一行数据的时候， 1 2 3 4 5
         * 遍历从左往右 1，2，3，4，5，然后从上到下，因为会往下一行递增，所以从上到下for循环是没有的
         * 但是从右往左的时候，因为起始点是right-1，此时是在当前行，这肯定会重复的，造成重复的是因为只有一行
         * 或者当前递归到最后一行的时候
         *
         * 同理一列的时候也是一样的
         */

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