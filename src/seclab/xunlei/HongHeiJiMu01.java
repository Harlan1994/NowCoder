package seclab.xunlei;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/12
 * Time: 19:55
 * Description:
 */
public class HongHeiJiMu01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] AB = scanner.nextLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        int[] array = new int[17];
        for (int i = 0; i < array.length; i++) {
            array[i] = B;
        }
        int result = A + 6 * B;
        array[0] = A;
        for (int i = 1; i < 7; i++) {
            if (result + A - B <= 0) {
                result = result + A - B;
                array[i] = A;
            }
        }
        for (int i = 7; i < 17; i++) {
            result = result + array[i] - array[i - 7];
            if (result + A - B <= 0) {
                array[i] = A;
                result = result + A - B;
            }
        }
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }
}
