package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/9
 * Time: 20:54
 * Description: 这是约瑟夫环问题
 * Solution: http://tingyun.site/2018/04/26/%E7%BA%A6%E7%91%9F%E5%A4%AB%E7%8E%AF%E9%97%AE%E9%A2%98%E8%AF%A6%E8%A7%A3/
 */
public class B11199_孩子们的游戏 {

    public static int LastRemaining_Solution(int n, int m) {
        if (n <= 0) return -1;
        if (n == 1) return 0;
        return josephus(n, m);
    }

    // n个人的环，报数为m
    public static int josephus(int n, int m) {
        if (n == 1) {
            return 0;
        } else {
            return (josephus(n - 1, m) + m) % n;
        }
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }
}
