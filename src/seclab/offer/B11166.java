package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/15
 * Time: 10:25
 * Description:
 */
public class B11166 {

    public void reOrderArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                count++; // 统计奇数的个数
            }
        }

        int[] newArray = new int[array.length];
        int odd = 0;
        int even = count;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                newArray[odd++] = array[i];
            } else {
                newArray[even++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++){
            array[i] = newArray[i];
        }
    }

    public static void main(String[] args) {

    }
}
