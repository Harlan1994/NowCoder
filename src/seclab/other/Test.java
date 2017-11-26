package seclab.other;

/**
 * User: Harlan1994
 * Date: 2017/8/10
 * Time: 15:41
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        String str = "???????aaaaa";
        str = str.replaceAll("\\?", "b");
        System.out.println(str);
    }
}