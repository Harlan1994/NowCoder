package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/5
 * Time: 14:09
 * Description:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class B11163_矩形覆盖 {

    // 通过分析可以知道其实还是斐波那契数列
    /**
     * target <= 0 大矩形为<= 2*0,直接return 1；
     * target = 1 大矩形为2*1，只有一种摆放方法，return1；
     * target = 2 大矩形为2*2，有两种摆放方法，return2；
     * target = n 分为两步考虑：
     * 第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
     * 第一次摆放一块 1*2 的小矩阵，则摆放方法总共为f(target - 2)
     */

    private static int[] fibonacci = new int[51];

    static {
        fibonacci[1] = 1;
        fibonacci[2] = 2;

        for (int i = 3; i <= 50; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
    }

    public int RectCover(int target) {
        return fibonacci[target];
    }
}
