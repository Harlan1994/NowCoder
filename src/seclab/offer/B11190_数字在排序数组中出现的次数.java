package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/7
 * Time: 14:46
 * Description:
 */
public class B11190_数字在排序数组中出现的次数 {
    public static void main(String[] args) {

    }

    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            } else {
                if (count > 0) break;
            }
        }
        return count;
    }
}
