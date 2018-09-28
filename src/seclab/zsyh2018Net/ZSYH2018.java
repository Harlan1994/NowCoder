package seclab.zsyh2018Net;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/25
 * Time: 16:03
 * Description:
 */
public class ZSYH2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dataLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(dataLine[0]);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(dataLine[i + 1]);
        }
        int maxDiff = Integer.MIN_VALUE;
        int maxIn = Integer.MIN_VALUE;

        //  once
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = data[j] - data[i]; // compute diff
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        // twice
        int maxDiff2_1 = Integer.MIN_VALUE;
        int maxDiff2_2 = Integer.MIN_VALUE;
        for (int i = 2; i < n - 2; i++) {

            for (int j = 0; j < i; j++) {
                for (int x = j + 1; x < i; x++) {
                    int diff2 = data[x] - data[j];
                    if (diff2 > maxDiff2_1) {
                        maxDiff2_1 = diff2;
                    }
                }
            }

            for (int j = i; j < n; j++) {
                for (int x = j + 1; x < n; x++) {
                    int diff3 = data[x] - data[j];
                    if (diff3 > maxDiff2_2) {
                        maxDiff2_2 = diff3;
                    }
                }
            }
            maxIn = (maxDiff2_1 + maxDiff2_2) > maxDiff ? (maxDiff2_1 + maxDiff2_2) : maxDiff;
        }

        System.out.println(maxIn);
    }
}
