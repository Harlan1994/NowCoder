package seclab.other;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/9
 * Time: 19:56
 * Description:
 */
public class RecursiveString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String test = scanner.next();

        // 从只删除一个字符开始，到删除length - 1个的情况
        for (int i = 0; i < test.length() - 1; i++) {

        }
    }

    public static boolean isRecursiveString(String str) {

        if (str.length() == 1) return true;

        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
