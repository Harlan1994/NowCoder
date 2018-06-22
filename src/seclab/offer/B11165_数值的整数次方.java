package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/21
 * Time: 21:21
 * Description:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * Solution: 求某个数的几次方很简单，只不过在计算时要知道一些特殊情况：
 * 1。当指数是负数时，底数不能为0，0^-2 = 1/0^2 = 1 / 0 明显是错误的。
 * 2。指数为负数和正数情况计算方式基本一致，只不过指数为负数时计算后要倒数一下
 * 3。任何书的0次方是1
 */
public class B11165_数值的整数次方 {

    // 普通写法
    public double Power(double base, int exponent) {
        // 任何数的0次方等于1
        double result = 1.0;
        if (exponent == 0) {
            return 1.0;
        } else if (exponent < 0) {
            // 指数小于零时，底数不能为0
            if (base == 0.0) {
                throw new RuntimeException();
            }

            // 指数为正负的两种情况，是负数，计算结果倒数即可
            for (int i = 0; i < (-exponent); i++) {
                result *= base;
            }
            return 1.0 / result;
        } else {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }
    }

    /**
     * from nowcoder:（但是用时感觉还多了好像。。。。。）
     *  1.全面考察指数的正负、底数是否为零等情况。
     *  2.写出指数的二进制表达，例如13表达为二进制1101。
     *  3.举例:10^1101 = 10^0001*10^0100*10^1000。
     *  4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public double Power(double base, int exponent, int a) {
        double result = 1.0;
        int n = exponent;
        if (exponent == 0) {
            return result;
        } else if (exponent < 0) {
            // 指数小于零时，底数不能为0
            if (base == 0.0) {
                throw new RuntimeException();
            }
            n = -exponent;
        } else {
            n = exponent;
        }

        double tmp = base;

        // 根据公式逐位乘
        while (n != 0) {
            if ((n & 1) == 1) { // 当前位是1
                result *= tmp;
            }

            // 向右移动一位
            n >>= 1;

            // 按照公式，每次向右移动一位，少乘一次x^2, x^4, x^8..., tmp *= tmp刚好满足 x^2, x^4....
            tmp *= tmp;
        }
        return exponent < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {
        B11165_数值的整数次方 b11165_数值的整数次方 = new B11165_数值的整数次方();
        System.out.println(b11165_数值的整数次方.Power(0, 4));
    }
}
