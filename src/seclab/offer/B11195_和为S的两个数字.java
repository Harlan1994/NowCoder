package seclab.offer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/7
 * Time: 22:08
 * Description:输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class B11195_和为S的两个数字 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxMulti = Integer.MAX_VALUE;
        int x = 0, y = 1;

        if(array == null || array.length == 0)return result;

        // 要想乘积最小，只需要从小到大遍历即可
        for (int i = 0; i < array.length; i++) {
            int current = array[i]; // 定位当前数字
            if (current > sum) { // 如果当前数字已经大于sum了，就直接返回
                return result;
            } else { // 否则从下一个开始匹配，如果和等于sum，也直接返回
                for (int j = i + 1; j < array.length; j++) {
                    int next = array[j];
                    if (current + next == sum) {
                        int multi = current * next;
                        if (multi < maxMulti) {
                            x = i;
                            y = j;
                            maxMulti = multi;
                        }
                    }
                }
            }
        }
        result.add(array[x]);
        result.add(array[y]);
        return result;
    }
}
