package seclab.other;

import java.util.Scanner;

/**
 * 重排序列
 */
public class C1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int t = in.nextInt();

            while (t-- > 0) {
                int n = in.nextInt();
                int[] countArr = new int[3];
                int firstCount = 0;

                // 输入并统计2因子个数（至多2）
                for (int i = 0; i < n; i++) {
                    int temp = in.nextInt();
                    int count = 0;

                    while (temp % 2 == 0 && count != 2) {
                        temp /= 2;
                        count++;
                    }
                    // 记录第一个因子个数
                    if (i == 0) {
                        firstCount = count;
                    }
                    // 记录个数
                    countArr[count]++;
                }
                // 尝试最大可能性
                int lastCount = firstCount;
                boolean success = true;
                countArr[lastCount]--;

                while (countArr[0] != 0 || countArr[1] != 0 || countArr[2] != 0) {
                    if (lastCount == 0) {
                        // 必须用2，没有就报错
                        if (countArr[2] == 0) {
                            success = false;
                            break;
                        } else {
                            countArr[2]--;
                            lastCount = 2;
                        }
                    } else if (lastCount == 1) {
                        // 能用1就用1，不能用1就用2，没有就报错
                        if (countArr[1] != 0) {
                            countArr[1]--;
                            lastCount = 1;
                        } else if (countArr[2] != 0) {
                            countArr[2]--;
                            lastCount = 2;
                        } else {
                            success = false;
                            break;
                        }
                    } else if (lastCount == 2) {
                        // 随便用什么，只剩2直接跳出
                        if (countArr[0] != 0) {
                            countArr[0]--;
                            lastCount = 0;
                        } else if (countArr[1] != 0) {
                            countArr[1]--;
                            lastCount = 1;
                        } else {
                            break;
                        }
                    }
                    if (countArr[0] == 0 && countArr[1] == 0 && countArr[2] == 0) {
                        break;
                    }
                }
                if (success) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}