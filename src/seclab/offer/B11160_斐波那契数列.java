package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/5
 * Time: 13:29
 * Description:大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class B11160_斐波那契数列 {

    // 直接打表就行了

    private static int[] fibonacci = new int[40];

    static {
        fibonacci[1] = 1;
        fibonacci[2] = 1;

        for (int i = 3; i <= 39; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
    }

    public int Fibonacci(int n) {
        return fibonacci[n];
    }
}
