package seclab.offer;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/16
 * Time: 11:40
 * Description:
 */
public class B11206_表示数值的字符串 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String charStr = scanner.nextLine();
            System.out.println(isNumeric(charStr.toCharArray()));
        }
    }

    /**
     * 开头的情况有：数字、正负号、E，e四种五种情况
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(char[] str) {

        int countOfE = 0;
        int indexOfE = -1;
        int countOfPoint = 0;
        int indexOfPoint = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                countOfE++;
                indexOfE = i;
            } else if (str[i] == '.') {
                countOfPoint++;
                indexOfPoint = i;
            }
        }

        if (countOfE > 1) return false; // E最多只能有一个
        if (countOfPoint > 1) return false; // 小数点只能有一个

        if (countOfE == 0) { // 没有E的话,那只能是纯数字了（开头可以有正负号，也可以有小数点，可能是小数，小数点不能放第一和最后）
            if (str[0] == '.' || str[str.length - 1] == '.') return false;

            if (str[0] == '+') {
            } else if (str[0] == '-') {
            } else if (str[0] <= '9' && str[0] >= '0') {
            } else {
                return false;
            }

            for (int i = 1; i < str.length; i++) {
                // 只存在一个小数点，所以可以是除了开头和结尾的任意位置，其他位置必须是数字
                if (!((str[i] <= '9' && str[i] >= '0') || str[i] == '.')) {
                    return false;
                }
            }
            return true;
        } else { // 有一个E的情况下，将E的前后部分分开分别判断是否是数字,此时后半部分不能有小数点,只能是允许正负号存在

            // E或者e不能是最后一个字符，也不能是第一个字符,也就是可以通过E或者e将两个数分开
            if (indexOfE == str.length - 1 || indexOfE == 0) return false;
            if (indexOfPoint == 0 || indexOfPoint == indexOfE - 1) return false;

            if (str[0] == '+') {
            } else if (str[0] == '-') {
            } else if (str[0] <= '9' && str[0] >= '0') {
            } else {
                return false;
            }

            for (int i = 1; i < indexOfE; i++) {
                if (!((str[i] <= '9' && str[i] >= '0') || str[i] == '.')) {
                    return false;
                }
            }

            if (str[indexOfE + 1] == '+') {
            } else if (str[indexOfE + 1] == '-') {
            } else if (str[indexOfE + 1] <= '9' && str[indexOfE + 1] >= '0') {
            } else {
                return false;
            }

            for (int i = indexOfE + 2; i < str.length; i++) {
                if (!(str[i] <= '9' && str[i] >= '0')) {
                    return false;
                }
            }
            return true;
        }
    }
}
