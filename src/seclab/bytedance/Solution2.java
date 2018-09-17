package seclab.bytedance;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/9
 * Time: 10:14
 * Description:
 */
public class Solution2 {

    private static int[][] a;
    private static int[][] b;
    private static int p = 0;
    private static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = Integer.parseInt(scanner.nextLine());

        a = new int[M + 1][M + 1];
        b = new int[M + 1][M + 1];

        for (int i = 1; i <= M; i++) {
            String[] split = scanner.nextLine().split(" ");
            for (int j = 1; j <= M; j++) {
                a[i][j] = Integer.parseInt(split[j]);
                b[i][j] = 0;
            }
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i][j] == 1 && b[i][j] == 0) {
                    core(i, j);
                    p++;
                }
            }
        }

        System.out.println(p);
    }

    public static void core(int x, int y) {
        if (x > M || y > M) return;
        if (a[x][y] == 1 && b[x][y] == 0) {
            b[x][y] = 1;
            core(x - 1, y);
            core(x, y - 1);
            core(x, y + 1);
            core(x + 1, y);
        }
    }
}
