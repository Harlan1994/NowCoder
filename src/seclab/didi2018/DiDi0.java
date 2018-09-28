package seclab.didi2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/18
 * Time: 20:59
 * Description:
 */
public class DiDi0 {

    static class Arr {

        Integer[] a;

        public Arr(Integer[] a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object obj) {

            if (!(obj instanceof Arr)) {
                return false;
            }

            Arr other = (Arr) obj;
            Integer[] othArr = other.a;

            if(this.a.length != othArr.length)return false;
            for (int i = 0; i < a.length; i++) {
                if (othArr[i].intValue() != this.a[i].intValue()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

        int np, nq, nr;
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        np = Integer.parseInt(strings[0]);
        nq = Integer.parseInt(strings[1]);
        nr = Integer.parseInt(strings[2]);

        set = new HashSet<>();

        Integer[] array = new Integer[np + nq + nr];

        int k = 0;
        while (nq != 0) {
            array[k++] = 0;
            nq--;
        }

        while (np != 0) {
            array[k++] = 1;
            np--;
        }

        while (nr != 0) {
            array[k++] = 2;
            nr--;
        }
        perm(array, array.length);
        System.out.println(set.size());
    }

    public static void swap(Integer[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static Set<Arr> set = new HashSet<>();

    /**
     * array数组从第k个元素到第n个元素的全排列
     *
     * @param array
     * @param k
     * @param n
     */
    public static void perm(Integer[] array, int k, int n) {

        // 如果排到了最后一个元素，那就不需要交换，直接输出即可
        if (k == n) {
            int c = array[0];
            boolean flag = false;
            for (int i = 1; i < n + 1; i++) {
                if (array[i] != c) {
                    c = array[i];
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                Arr arr = new Arr(array);
                set.add(arr);
            }
        } else { //否则从第一个元素开始，到最后一个元素进行交换，并得到全排列
            for (int i = k; i <= n; i++) {
                swap(array, k, i);
                perm(array, k + 1, n);
                swap(array, k, i);
            }
        }
    }

    public static void perm(Integer[] array, int length) {
        perm(array, 0, length - 1);
    }
}

