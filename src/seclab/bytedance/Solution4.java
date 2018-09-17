package seclab.bytedance;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/9
 * Time: 10:14
 * Description:
 */
public class Solution4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] data = new int[N];
        String[] dataStr = scanner.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(dataStr[i]);
        }

        System.out.println(validate(data) ? "1" : "0");
    }

    public static boolean validate(int[] data) {
        if (data == null || data.length == 0) return false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 255) return false;
            int bytes;
            if ((data[i] & 128) == 0) {
                bytes = 1;
            } else if ((data[i] & 224) == 192) {
                bytes = 2;
            } else if ((data[i] & 240) == 224) {
                bytes = 3;
            } else if ((data[i] & 248) == 240) {
                bytes = 4;
            } else {
                return false;
            }
            for (int j = 1; j < bytes; j++) {
                if (i + j >= data.length) return false;
                if ((data[i + j] & 192) != 128) return false;
            }
            i = i + bytes - 1;
        }
        return true;
    }
}
