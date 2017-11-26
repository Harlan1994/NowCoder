package seclab.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/9/21
 * Time: 19:49
 * Description:
 */
public class YZ3 {

    public static void main(String[] args) {
        int n;
        int min = 1;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        List<Integer> arrays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            if (temp == min) {
                min++;
                while (arrays.contains(min)) {
                    min++;
                }
            }
        }
        System.out.println(min);
    }
}