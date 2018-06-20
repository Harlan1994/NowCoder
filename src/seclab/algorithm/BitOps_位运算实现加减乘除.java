package seclab.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/15
 * Time: 15:44
 * Description:
 */
public class BitOps_位运算实现加减乘除 {

    public static void main(String[] args) {

    }

    public static int add(int num1, int num2) {
        int sum = num1 ^ num2; // 不计进位的和
        int carry = (num1 & num2) << 1; // 进位左移一位
        while (carry != 0) { // 当有进位时
            int a = sum;
            int b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }

    public static int sub(int a, int b) {

        // 先计算b的相反数， 即-b，取反加1即可，就是求b的补码形式
        int subtranhend = add(~b, 1);
        int subs = add(a, subtranhend);
        return subs;
    }

    public static int mul(int a, int b) {

        // 先求绝对值
        int multiplier = a < 0 ? add(~a, 1) : a;
        int multiplicant = b < 0 ? add(~b, 1) : b;

        int product = 0;
        int count = 0;
        while (count < multiplier) {
            product = add(product, multiplicant);
            count = add(count, 1);
        }

        // 判断乘积的符号，异或运算是相同位0不同为1，如果符号位相同则
        // 异或后的结果符号位位0，是正的，反之不相同是负的
        if ((a ^ b) < 0) {
            product = add(~product, 1);
        }

        return product;
    }

    public static int mul_advanced(int a, int b) {
        // 先求绝对值
        int multiplier = a < 0 ? add(~a, 1) : a;
        int multiplicant = b < 0 ? add(~b, 1) : b;

        int product = 0;
        while (multiplier != 0) { // 如果当前位不为0，则需要加上multiplicant
            product = add(product, multiplicant);
            multiplicant <<= 1;
            multiplier >>= 1;
        }

        // 判断乘积的符号，异或运算是相同位0不同为1，如果符号位相同则
        // 异或后的结果符号位位0，是正的，反之不相同是负的
        if ((a ^ b) < 0) {
            product = add(~product, 1);
        }

        return product;
    }

    public static int[] div(int a, int b) {
        // 对被除数和除数分别求绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int dividor = b < 0 ? add(~b, 1) : b;

        // 定义余数和值
        int remainder = dividend; // 当前余数是被除数
        int quotient = 0;

        // 当还剩下的比除数大，继续减,然后值加上1
        while (remainder > dividor) {
            remainder = sub(remainder, dividor);
            quotient = add(quotient, 1);
        }

        // 最终的值的符号和被除数除数的符号有关，相同为正，不同为负
        if ((a ^ b) < 0) { // 符号不一致
            quotient = add(~quotient, 1);
        }

        // 余数的符号和被除数的一致
        if (b < 0) {
            remainder = add(~remainder, 1);
        }

        int[] result = new int[2];
        result[0] = quotient;
        result[1] = remainder;

        return result;
    }

    public static int[] div_advanced(int a, int b){
        return new int[2];
    }
}
