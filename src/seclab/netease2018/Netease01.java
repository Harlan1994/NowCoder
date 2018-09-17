package seclab.netease2018;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/11
 * Time: 12:56
 * Description:
 */


public class Netease01 {

    public static void main(String[] args) {
        Netease01 netease01 = new Netease01();
        netease01.test();
    }

    public void test() {
        Scanner scanner = new Scanner(System.in);
        int n, k, score = 0, wScore = 0, max = -1;
        int[] a, t;

        n = scanner.nextInt();
        k = scanner.nextInt();

        a = new int[n];
        t = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                score += a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (t[i] != 1) {
                int j = 0;
                while (j < k && i + j < n) {
                    if (t[i + j] == 1) {
                        j++;
                        continue;
                    }
                    wScore += a[i + j];
                    j++;
                }
                if (wScore > max) {
                    max = wScore;
                }
                wScore = 0;
            }
        }
        System.out.println(score + max);
    }
}
