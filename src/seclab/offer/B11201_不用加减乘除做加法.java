package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/15
 * Time: 15:21
 * Description:写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class B11201_不用加减乘除做加法 {

    /**
     * 使用位运算，其实就是把num1和num2的二进制形式相加
     *
     * 从低到高位开始，
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1, int num2) {
        int result = 0;
        while (num2 != 0) {
            /**
             * 整个过程是这样的：1 就是相加了每一位的值，不计算进位的，就是进位的后面再算，如果没有进位其实这一步就行了
             * 2 计算进位的，由于进位是要加到更高位，所以进位左移一位，然后在下一次循环的时候
             * 在 1 中加进去，也就是说每次都是一次进位，直到没有进位的时候就是加完了
             */
            result = num1 ^ num2; // 相当于只加不进位 1
            num2 = (num1 & num2) << 1; // 只考虑进位，进位的值需要向左移动然后加进去 2
            num1 = result;
        }
        return num1;
    }
}
