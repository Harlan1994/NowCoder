package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/15
 * Time: 11:05
 * Description:
 */
public class B11202_把字符串转换成整数 {

    public static void main(String[] args) {
        System.out.println(StrToInt("+2147483647"));
    }

    public static int StrToInt(String str) {
        if(str.length() <= 0)return 0;
        int k = 1;
        int result = 0;
        boolean sign = true;
        if (str.charAt(0) == '+') {
            sign = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            sign = false;
            str = str.substring(1);
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            char at = str.charAt(i);
            if (at <= '9' && at >= '0') {
                result += k * (at - 48);
                k *= 10;
            } else {
                return 0;
            }
        }
        if (!sign) {
            result = -result;
        }
        return result;
    }
}
