package seclab.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/22
 * Time: 21:16
 * Description:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class B11181_数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        B11181_数组中出现次数超过一半的数字 b11181_数组中出现次数超过一半的数字 = new B11181_数组中出现次数超过一半的数字();
        int result = b11181_数组中出现次数超过一半的数字.MoreThanHalfNum_Solution(new int[]{1});
        System.out.println(result);
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> integers = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (integers.get(array[i]) == null) {
                integers.put(array[i], 1);
                if (1 > array.length / 2) {
                    return array[i];
                }
            } else {
                int curTimes = integers.get(array[i]) + 1;
                if (curTimes > array.length / 2) {
                    return array[i];
                }
                integers.put(array[i], curTimes);
            }
        }
        return 0;
    }
}
