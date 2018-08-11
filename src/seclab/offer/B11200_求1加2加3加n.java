package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/10
 * Time: 10:13
 * Description:
 */
public class B11200_求1加2加3加n {

    public int Sum_Solution(int n) {
        return (n + n * (n - 1) / 2);
    }
}
