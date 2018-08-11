package seclab.pingduoduo;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/5
 * Time: 18:57
 * Description:
 */
public class Ping01 {

    public static void main(String[] args) {
        Ping01 ping01 = new Ping01();
        ping01.print();
    }

    public void print() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int k = s.length() / 4;

        char[][] map = new char[k + 1][k + 1];
        int j = 0;
        for (int i = 0; i < k + 1; i++) { // 上面
            map[0][i] = s.charAt(j++);
        }
        for (int i = 1; i < k + 1; i++) { // 右边
            map[i][k] = s.charAt(j++);
        }
        for (int i = k - 1; i >= 0; i--) { // 下面
            map[k][i] = s.charAt(j++);
        }
        for (int i = k - 1; i > 0; i--) {
            map[i][0] = s.charAt(j++);
        }

        for (int i = 0; i < k + 1; i++) {
            for (int x = 0; x < k + 1; x++) {
                if (map[i][x] != '\0') {
                    System.out.print(map[i][x]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
