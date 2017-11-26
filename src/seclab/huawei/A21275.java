package seclab.huawei;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/8
 * Time: 21:06
 * Description: 字符串的编辑距离
 */
public class A21275 {

    public static int calStringDistance(String charA, String charB) {
        int[][] ptr = new int[charA.length() + 1][charB.length() + 1];
        for (int i = 0; i < charA.length() + 1; i++) {
            ptr[i][0] = i;
        }

        for (int j = 0; j < charB.length() + 1; j++) {
            ptr[0][j] = j;
        }
        int d;
        for (int i = 1; i < charA.length() + 1; i++) {
            for (int j = 1; j < charB.length() + 1; j++) {
                int temp = Math.min(ptr[i - 1][j] + 1, ptr[i][j - 1] + 1);
                if (charA.charAt(i - 1) == charB.charAt(j - 1)) {
                    d = 0;
                } else {
                    d = 1;
                }
                ptr[i][j] = Math.min(temp, ptr[i - 1][j - 1] + d);
            }
        }
        return ptr[charA.length()][charB.length()];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String charA = input.nextLine();
            String charB = input.nextLine();
            System.out.println(calStringDistance(charA, charB));
        }
    }
}