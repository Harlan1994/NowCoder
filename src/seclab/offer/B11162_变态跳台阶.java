package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/21
 * Time: 21:14
 * Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * Solution: 同上面的分析，F[n] = F[n-1] + F[n-2] + F[n-3] + ... + F[1] + 1（n级一起跳的）
 */
public class B11162_变态跳台阶 {

    public static void main(String[] args) {
        B11162_变态跳台阶 b11162_变态跳台阶 = new B11162_变态跳台阶();
        int result = b11162_变态跳台阶.JumpFloorII(3);
        System.out.println(result);
    }


    public int JumpFloorII(int target) {
        int[] fibonacci = new int[50];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        for (int i = 3; i < 50; i++) {
            for (int j = i - 1; j >= 1; j--) {
                fibonacci[i] += fibonacci[j];
            }
            // 还有一次跳n级的
            fibonacci[i] += 1;
        }
        return fibonacci[target];
    }
}
