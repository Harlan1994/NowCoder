package seclab.didi2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/18
 * Time: 19:51
 * Description:
 */
public class DiDi01 {

    public static int count = 0;
//    public static List<int[]> set = new ArrayList<>();

    public static void main(String[] args) {
        int np, nq, nr;
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        np = Integer.parseInt(strings[0]);
        nq = Integer.parseInt(strings[1]);
        nr = Integer.parseInt(strings[2]);
        int count = 0;
        List<Integer> qiu = new ArrayList<>(np + nq + nr);
        for (int i = 0; i < qiu.size(); i++) {
            qiu.add(i, -1);
        }
        DFS(np, nq, nr, qiu, 0);
        System.out.println(qiu.size());
    }

    private static void DFS(int np, int nq, int nr, List<Integer> qiu, int cur) {

        // 假如到了最后一个球
        if ((np + nr + nq) == 1) {
            if (np == 1) { // 如果是p颜色的
                if (qiu.get(cur - 1) != 0) { // 0表示是p颜色
                    qiu.add(cur, 0);
                }
            } else if (nr == 1) {
                if (qiu.get(cur - 1) != 1) { // 1表示是r颜色
                    qiu.add(cur, 1);
                }
            } else if (nq == 1) {
                if (qiu.get(cur - 1) != 2) {
                    qiu.add(cur, 1);
                }
            }
            return;
        }

        // 深度优先这三种颜色
        if (np != 0) {
            if (cur == 0) {
                qiu.add(cur, 0);
                if (cur < qiu.size() - 1) {
                    DFS(--np, nq, nr, qiu, ++cur);
                    qiu.add(cur, -1);
                    np++;
                }
            } else {
                if (qiu.get(cur - 1) != 0) {
                    qiu.add(cur, 0);
                    if (cur < qiu.size() - 1) {
                        DFS(--np, nq, nr, qiu, ++cur);
                        qiu.add(cur, -1);
                        np++;
                    }
                }
            }
        }

        if (nr != 0) {
            if (cur == 0) {
                qiu.add(cur, 1);
                if (cur < qiu.size() - 1) {
                    DFS(np, nq, --nr, qiu, ++cur);
                    qiu.add(cur, -1);
                    nr++;
                }
            } else {
                if (qiu.get(cur - 1) != 1) {
                    qiu.add(cur, 1);
                    if (cur < qiu.size() - 1) {
                        DFS(np, nq, --nr, qiu, ++cur);
                        qiu.add(cur, -1);
                        nr++;
                    }
                }
            }
        }

        if (nq != 0) {
            if (cur == 0) {
                qiu.add(cur, 2);
                if (cur < qiu.size() - 1) {
                    DFS(np, --nq, nr, qiu, ++cur);
                    qiu.add(cur, -1);
                    nq++;
                }
            } else {
                if (qiu.get(cur - 1) != 2) {
                    qiu.add(cur, 2);
                    if (cur < qiu.size() - 1) {
                        DFS(np, --nq, nr, qiu, ++cur);
                        qiu.add(cur, -1);
                        nq++;
                    }
                }
            }
        }
    }
}
