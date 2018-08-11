package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/17
 * Time: 11:11
 * Description:在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class B11203_数组中重复的数字 {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if(length == 0 || numbers == null){duplication[0] = -1;return false;}
        int[] flags = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            if (flags[numbers[i]] == 1) {
                duplication[0] = numbers[i];
                return true;
            } else {
                flags[numbers[i]] = 1;
            }
        }
        return false;
    }
}
