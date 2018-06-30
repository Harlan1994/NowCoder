package seclab.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/23
 * Time: 15:47
 * Description:
 */
public class Solution1 {

    public static void main(String[] args) {
        int n, m, k;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        List<Record> records = new ArrayList<>();

        scanner.nextLine();

        for (int i = 0; i < k; i++) {
            String[] info = scanner.nextLine().trim().split(" ");
            Record record = new Record();
            record.setX(Integer.parseInt(info[0]));
            record.setY(Integer.parseInt(info[1]));
            record.setZ(Integer.parseInt(info[2]));
            Time time = new Time();

            String timeStr = info[3];
            String[] strs = timeStr.split(":");
            time.setHour(Integer.parseInt(strs[0]));
            time.setMin(Integer.parseInt(strs[1]));
            time.setSec(Float.parseFloat(strs[2]));
            record.setT(time);
            records.add(record);
        }

        /**
         * 2 2 4
         1 1 0 18:00:00.000
         1 1 1 20:00:00.000
         1 1 0 18:00:01.000
         1 2 0 18:00:02.000
         */

        // 初始化为0
        int[][] grid = new int[n + 1][m + 1];

        int[][] gridTmp = null;
        int curLightNum = 0;
        int maxLightNum = -1;
//        Record maxLightNumRecord;

        // 按时间顺序排序每一条记录
        Collections.sort(records);

        // 遍历每一条记录，每次都刷新当前记录后的grid状态
        for (Record record : records) {
             // 修改状态
            if (record.getZ() == 1) {
                grid[record.getX()][record.getY()] = 0;
                curLightNum--;
            } else {
                grid[record.getX()][record.getY()] = 1;
                curLightNum++;
            }

            if (curLightNum > maxLightNum) {
                maxLightNum = curLightNum;
//                maxLightNumRecord = record;
                gridTmp = new int[n + 1][m + 1];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        gridTmp[i][j] = grid[i][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(gridTmp[i][j]);
            }
            System.out.println();
        }
    }

    static class Time {
        int hour;
        int min;
        float sec;

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public float getSec() {
            return sec;
        }

        public void setSec(float sec) {
            this.sec = sec;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Time) {
                Time time = (Time) obj;
                return time.getSec() == this.getSec() && time.getMin() == this.getMin() && time.getHour() == this.getHour();
            } else {
                return false;
            }
        }
    }


    static class Record implements Comparable<Record> {
        int x, y, z;

        Time t;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }

        public Time getT() {
            return t;
        }

        public void setT(Time t) {
            this.t = t;
        }

        @Override
        public int compareTo(Record o) {
            // 从早到晚顺序排列，即从小到大顺序
            if (this.getT().getHour() != o.getT().getHour()) {
                return this.getT().getHour() - o.getT().getHour();
            } else if (this.getT().getMin() != o.getT().getMin()) {
                return this.getT().getMin() - o.getT().getMin();
            } else {
                return (int) (this.getT().getSec() - o.getT().getSec());
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Record) {
                Record record = (Record) obj;
                return this.getT().equals(record.getZ()) && this.getX() == record.getX() &&
                        this.getY() == record.getY()
                        && this.getZ() == record.getZ();
            } else {
                return false;
            }
        }
    }
}
