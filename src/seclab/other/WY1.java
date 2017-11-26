package seclab.other;

/**
 * User: Harlan1994
 * Date: 2017/9/9
 * Time: 15:47
 * Description:
 */
public class WY1 {

    static int count = 0;

    public static void main(String[] args) {


    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    static void perm(char[] array, int k, int n) {

        //如果排到了最后一个元素，那就不需要交换，直接输出即可
        if (k == n) {
            System.out.println(array);
            count++;
        } else { //否则从第一个元素开始，到最后一个元素进行交换，并得到全排列
            for (int i = k; i <= n; i++) {
                swap(array[k], array[i]);
                perm(array, k + 1, n);
                swap(array[k], array[i]);
            }
        }
    }

    static void perm(char[] array, int length) {
        perm(array, 0, length - 1);
    }
}