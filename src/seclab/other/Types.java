package seclab.other;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/10/20
 * Time: 20:38
 * Description:
 */
public class Types {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            // init = 0, 没有融化
            int[][] matrix = new int[n + 1][m + 1];

            int tempY1 = y1;
            int tempY2 = y2;
            int tempX1 = x1;
            int tempX2 = x2;

            // 两个点融化了
            matrix[tempX1 + 1][tempY1 + 1] = 1;
            matrix[tempX2 + 1][tempY2 + 1] = 1;

            System.out.println("Before move top and left.");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            // 先到左上角
            // 一直向左移动
            while (tempY1 > 1 && tempY2 > 1) {
                tempY1--;
                tempY2--;
            }

            // 一直向上移动
            while (tempX1 > 1 && tempX2 > 1) {
                tempX1--;
                tempX2--;
            }

            int y11 = tempY1;
            int y22 = tempY2;

            matrix[tempX1][tempY1] = 1;
            matrix[tempX2][tempY2] = 1;
            System.out.println("After move top and left.");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Current point x1 = " + (tempX1) + ", point y1 = " + (tempY1));
            System.out.println("Current point x2 = " + (tempX2) + ", point y2 = " + (tempY2));

            System.out.println();

            // 已经到了左上角
            // 现在从左往右，从上往下移动
            while (tempX1 >= 1 && tempX1 <= n && tempX2 >= 1 && tempX2 <= n) {
                matrix[tempX1][tempY1] = 1;
                matrix[tempX2][tempY2] = 1;

                System.out.println("Current point x1 = " + (tempX1 + 1) + ", point y1 = " + (tempY1 + 1));
                System.out.println("Current point x2 = " + (tempX2 + 1) + ", point y2 = " + (tempY2 + 1));

                tempY1++;
                tempY2++;

                if (tempY1 > m || tempY2 > m) {
                    tempY1 = y11;
                    tempY2 = y22;
                    tempX1++;
                    tempX2++;
                }
            }

            System.out.println("After All moves.");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (matrix[i][j] == 0) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}