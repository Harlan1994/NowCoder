package seclab.other;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/9/9
 * Time: 19:55
 * Description:
 */
public class WY1_ {

    private static int numOf2(int number) {
        int count = 0;
        while (number % 2 == 0 && count != 2) { // count 最大是2，即两个2的因子
            count++;
            number /= 2;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();
        while (caseNum-- > 0) {

            int n = scanner.nextInt();
            int[] array = new int[n];
            int[] flag = new int[2];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
                int count = numOf2(array[i]);
                flag[count]++;
            }
            boolean success = false;
            int current = -1; // 从最小的开始匹配
            if (flag[0] > 0) current = 0;
            if (flag[1] > 0 && current != 0) current = 1;
            if (flag[2] > 0 && current != 1) current = 2;
            while (flag[0] == 0 && flag[1] == 0 && flag[2] == 0) {
                if (current == 0) { // 因子没有一个2的只能和因子有两个2的匹配才能保证能被4整除
                    if (flag[2] <= 0) {
                        success = false;
                        break;
                    } else {
                        flag[2]--;
                        current = 2; // 当前的数是有两个2因子
                    }
                } else if (current == 1) { // 因子只有一个2时，需要先从因子只有2的里面匹配，否则从因子2有两个里面匹配，否则失配
                    if (flag[1] <= 0) {
                        if (flag[2] <= 0) {
                            success = false;
                            break;
                        } else {
                            flag[2]--;
                            current = 2;
                        }
                    } else {
                        flag[1]--;
                        current = 1;
                    }
                }else{

                }
            }
        }
    }
}