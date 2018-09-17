package seclab.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/15
 * Time: 11:17
 * Description:
 */
public class XCAP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Schedule> schedules = new ArrayList<>();
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N / 2; i++) {
            float A = Float.parseFloat(scanner.nextLine());
            float B = Float.parseFloat(scanner.nextLine());
            Schedule schedule = new Schedule(A, B);
            schedules.add(schedule);
        }

        Schedule first = schedules.get(0);
        int count = 0;

        Collections.sort(schedules);
        for (int i = 1; i < schedules.size(); i++) {
            Schedule other = schedules.get(i);
            if (Schedule.isOverride(first, other)) {
                count++;
            } else {
                first = other;
            }
        }
        System.out.println(count);
    }

    static class Schedule implements Comparable<Schedule> {
        float start;
        float end;

        public Schedule(float start, float end) {
            this.start = start;
            this.end = end;
        }

        public static boolean isOverride(Schedule scheduleA, Schedule scheduleB) {
            if (scheduleA.start > scheduleB.end) {
                return false;
            }

            if (scheduleA.end < scheduleB.start) {
                return false;
            }

            return true;
        }


        @Override
        public int compareTo(Schedule o) {
            if (o.end < this.end) {
                return 1;
            } else if (o.end == o.end) {
                if ((o.end - o.start) < (this.start - this.end)) {
                    return 1;
                } else if ((o.end - o.start) == (this.start - this.end)) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}
