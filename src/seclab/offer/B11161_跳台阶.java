package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/21
 * Time: 21:04
 * Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * Solution: 假设F[n]为跳n级台阶的跳法种数，由于只有两种跳法：
 * 我们假设第一次只跳一个台阶，那么剩下n-1有F[n-1]种跳法
 * 假设第一次只跳两个台阶，那么剩下n-2个台阶有F[n-2]种跳法
 * 所以有：F[n] = F[n-1] + F[n-2] 很明显的fibonacci数列
 */
public class B11161_跳台阶 {

    public static void main(String[] args) {

    }


    // 打表应该不会超过 50
    public int JumpFloor(int target) {
        int[] fibonacci = new int[50];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        for (int i = 3; i < 50; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[target];
    }
}
