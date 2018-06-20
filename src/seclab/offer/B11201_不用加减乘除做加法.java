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
            result = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = result;
        }
        return num1;
    }
}
