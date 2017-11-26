package seclab.other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 多线程数据统计
 */
public class D51 {
    public static String STR;
    public static int LEN, ONE_LEN;
    public static int SUM;
    public static int arr[] = new int[3];

    public static class MyThread implements Runnable {
        int i;
        int start, end;
        Object lock;

        public MyThread(int i, Object lock) {
            this.i = i;
            this.lock = lock;
        }

        @Override
        public void run() {
            start = i * ONE_LEN;
            if (i <= 1) {
                end = ONE_LEN * (i + 1) - 1;
            } else {
                end = LEN - 3;
            }

            for (int j = start; j <= end; j++) {
                if (STR.substring(j, j + 3).equals("u51")) {
                    synchronized (lock) {
                        SUM++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in
//
//        );
//        Object lock = new Object();
//        SUM = 0;
//
//        while (in.hasNext()) {
//            STR = in.nextLine();
//            LEN = STR.length();
//            ONE_LEN = LEN / 3;
//            Arrays.fill(arr, 0);
//
//            for (int i = 0; i < 3; i++) {
//                new MyThread(i, lock).run();
//            }
//        }
//        System.out.println(SUM);

    }

    public boolean Find(int target, int [][] array) {
        if(array == null || array.length <= 0 || array[0] == null || array[0].length <= 0)return false;
        return Find(target, 0, 0, array.length - 1, array[0].length - 1, array);
    }

    public boolean Find(int target, int start_row, int start_column, int end_row, int end_column, int[][] array) {
        if (end_row - start_row < 0 || end_column - start_column < 0) return false;
        // 从右上角开始
        if (array[start_row][end_column] == target) return true;
        else {
            if (array[start_row][end_column] > target) {
                return Find(target, start_row, start_column, end_row, end_column - 1, array);
            } else {
                return Find(target, start_row + 1, start_column, end_row, end_column, array);
            }
        }
    }
}
