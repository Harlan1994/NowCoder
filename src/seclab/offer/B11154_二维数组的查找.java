package seclab.offer;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/14
 * Time: 22:24
 * Description:二维数组的查找
 */
public class B11154_二维数组的查找 {

    static int i = -1;
    static int j = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        B11154_二维数组的查找 test = new B11154_二维数组的查找();
        int target;
        target = scanner.nextInt();
        int m; int n;
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        test.Find(target, array, m - 1, n - 1);
        System.out.println(i + " " + j);
    }

    public boolean Find(int target, int start_row, int start_column, int end_row, int end_column, int[][] array) {
        if (end_row - start_row < 0 || end_column - start_column < 0) return false;
        // 从右上角开始
        if (array[start_row][end_column] == target) {
            i = start_row;
            j = end_column;
            return true;
        } else {
            if (array[start_row][end_column] > target) {
                return Find(target, start_row, start_column, end_row, end_column - 1, array);
            } else {
                return Find(target, start_row + 1, start_column, end_row, end_column, array);
            }
        }
    }

    public boolean Find(int target, int[][] array, int m, int n) {
        // System.out.printf("%d %d", array.length - 1, array[0].length - 1);
        return Find(target, 0, 0, m, n, array);
    }
}