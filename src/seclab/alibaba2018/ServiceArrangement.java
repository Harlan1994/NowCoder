package seclab.alibaba2018;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/11
 * Time: 20:10
 * Description:
 */
public class ServiceArrangement {

    public static void main(String[] args) {

    }

    public static void exist() {
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        int limit = scanner.nextInt();
        int[][] pairs = new int[limit][2];
        for (int i = 0; i < limit; i++) {
            String pair = scanner.nextLine();
            String[] nos = pair.split(",");
            pairs[i][0] = Integer.parseInt(nos[0]);
            pairs[i][1] = Integer.parseInt(nos[1]);
        }

        for (int i = 0; i < groupNum; i++) {
        }
    }
}
