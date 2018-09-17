package seclab.xunlei;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/12
 * Time: 19:19
 * Description:
 */
public class SuGouGuShu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        System.out.println(count(N));
    }

    private static int[] used = new int[100000];

    private static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }

    private static int count(int n) {
        int a, b, c;
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n + 0.5); i++) {
            for (int j = i + 1; j * i <= n; j += 2) {
                if (gcd(i, j) == 1) { // 互质
                    a = j * j - i * i;
                    b = 2 * i * j;
                    c = i * i + j * j;
                    if (c <= n) {
                        count++;
                        if (used[a] == 0) {
                            used[a] = 1;
                        }
                        if (used[b] == 0) {
                            used[b] = 1;
                        }
                        if (used[c] == 0) {
                            used[c] = 1;
                        }
                    }
                    for (int k = 2; k * c <= n; k++) {
                        if (used[k * a] == 0) {
                            used[k * a] = 1;
                        }
                        if (used[k * b] == 0) {
                            used[k * b] = 1;
                        }
                        if (used[k * c] == 0) {
                            used[k * c] = 1;
                        }
                    }
                }
            }
        }
        return count;
    }
}
