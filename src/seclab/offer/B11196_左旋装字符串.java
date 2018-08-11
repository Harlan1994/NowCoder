package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/9
 * Time: 20:44
 * Description:
 */
public class B11196_左旋装字符串 {

    public static void main(String[] args) {

    }

    public String LeftRotateString(String str, int n) {
        if(n > str.length() || str == null || "".equals(str))return "";
        return str.substring(n) + str.substring(0, n);
    }
}
