package seclab.huawei;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/6
 * Time: 20:31
 * Description:
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作。
 */
public class A21226 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int N = input.nextInt();
            int num[] = new int[1001];
            for (int i = 1; i <= N; i++) {
                int tempNum = input.nextInt();
                num[tempNum] = 1;
            }

            for (int i = 1; i <= 1000; i++) {
                if (num[i] == 1) {
                    System.out.println(i);
                }
            }
        }
    }
}