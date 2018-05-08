package seclab.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/2
 * Time: 09:56
 * Description: 丑数
 */
public class B11186 {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(2));
    }

    public static int GetUglyNumber_Solution(int index) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int q2 = 0;
        int q3 = 0;
        int q5 = 0;
        while (list.size() < index) {

            // 计算三个分支
            int m2 = list.get(q2) * 2;
            int m3 = list.get(q3) * 3;
            int m5 = list.get(q5) * 5;

            //  求出分支中最小的
            int min = Math.min(m2, Math.min(m3, m5));

            list.add(min);

            // 判定是哪个分支(是乘以2的还是乘以3的还是乘以5的分支)
            // 加入是乘以2的分支，那么q2++,也就是说当前新add进入的是某个分支乘以2的
            if (m2 == min) {
                q2++;
            }
            if (m3 == min) {
                q3++;
            }
            if (m5 == min) {
                q5++;
            }
        }
        return list.get(index - 1);
    }
}