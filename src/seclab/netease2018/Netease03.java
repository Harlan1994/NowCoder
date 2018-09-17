package seclab.netease2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/11
 * Time: 12:5
 * Description:
 */
public class Netease03 {

    public static void main(String[] args) {
        Netease03 netease03 = new Netease03();
        netease03.test();
    }

    public void test() {
        Scanner scanner = new Scanner(System.in);

        int n, m, k;

        String[] split = scanner.nextLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);

        Set<String> strings = new HashSet<>();
        strings = generateAll(n, m);
    }

    public Set<String> generateAll(int countOfA, int countOfZ) {
        return null;
    }
}
