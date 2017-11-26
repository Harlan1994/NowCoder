package seclab.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/9/21
 * Time: 20:24
 * Description:
 */
public class YZ4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in

        );
        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int[] nums1 = new int[num1];
            for (int i = 0; i < num1; i++) {
                nums1[i] = sc.nextInt();
            }

            int num2 = sc.nextInt();
            int[] nums2 = new int[num2];
            for (int i = 0; i < num2; i++) {
                nums2[i] = sc.nextInt();
            }

            int i = 0, j = 0;

            int x, y;
            if (num1 + num2 % 2 == 0) {
                x = (num1 + num2) / 2;
                y = x + 1;
            } else {
                x = y = (num1 + num2) / 2 + 1;
            }
            boolean flag = false;
            while (i < num1 && j < num2) {
                if (nums1[i] < nums2[j]) {
                    i++;
                    flag = false;
                } else {
                    j++;
                    flag = true;
                }

                if (i + j == x + y) {
                    if (x == y) {
                        System.out.println(flag ? nums2[j] : nums1[i]);
                    } else {

                    }
                }
            }
        }
    }
}