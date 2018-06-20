package seclab.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/17
 * Time: 14:45
 * Description:
 */
public class B11185_把数组排成最小的数 {


    // 定义一个按照某种规则排序的排序器
    static class Com<Integer> implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String num1 = o1.toString() + o2.toString();
            String num2 = o2.toString() + o1.toString();
            return num1.compareTo(num2);
        }
    }

    public static String PrintMinNumber(int[] numbers) {

        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }

        Arrays.sort(nums, new Com<>());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber(new int[]{3, 32, 321});
    }
}
