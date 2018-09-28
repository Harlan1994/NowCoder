package seclab.sorting;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/18
 * Time: 19:36
 * Description:
 */
public class QuickSort {

    public static int partition(int array[], int low, int high) {
        int pivotKey = array[low];
        int l = low, h = high;
        while (l < h) {
            while (l < h && array[h] >= pivotKey) h--;
            array[l] = array[h];
            while (l < h && array[l] <= pivotKey) l++;
            array[h] = array[l];
            array[l] = pivotKey;
        }
        return l;
    }

    public static void sort(int array[], int low, int high) {
        if (low >= high) return;
        int pivotKey = partition(array, low, high);
        sort(array, low, pivotKey);
        sort(array, pivotKey + 1, high);
    }

    public static void quickSort(int array[], int length) {
        sort(array, 0, length - 1);
    }

    public static void main(String[] args) {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 0, 10, 23, 55, 1093, 1, 222, 454};
        quickSort(a, 15);
        for (int i = 0; i <= 14; i++) {
            System.out.print(a[i] + " ");             //输出测试
        }
    }
}
