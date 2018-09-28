package seclab.sorting;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/9
 * Time: 11:24
 * Description:
 *
 *
 */
public class MergeSort {

    public static void merge(int[] array, int start, int mid, int end) {
        int[] tmp = new int[array.length];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) tmp[k++] = array[i] > array[j] ? array[j++] : array[i++];
        while (i <= mid) tmp[k++] = array[i++];
        while (j <= end) tmp[k++] = array[j++];

        // 合并的是从start到end，所以需要将其复位
        for (int s = start, r = 0; s <= end; s++, r++) {
            array[s] = tmp[r];
        }
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 5, 7, 2, 10, 90, 10, 23, 43, 12};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
