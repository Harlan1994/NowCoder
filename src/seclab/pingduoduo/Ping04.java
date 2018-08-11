package seclab.pingduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/5
 * Time: 18:57
 * Description:
 */
public class Ping04 {

    int[] f;

    public static void main(String[] args) {
        Ping04 ping04 = new Ping04();
        int result = ping04.test();
        System.out.println(result);
    }

    public int test() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] seq = new int[N];
        f = new int[N];

        String[] split = scanner.nextLine().split(" ");

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(split[i]);
        }
        int count = 0;
        while (true) {
            // 计算本轮最多可以拿多少
            List<Integer> indexIncr = countNum(seq, true);
            List<Integer> indexDecr = countNum(seq, false);
            if (indexDecr == null || indexIncr == null) {
                return count;
            } else {
                if (indexDecr.size() > indexIncr.size()) {
                    for (int j = 0; j < indexDecr.size(); j++) {
                        f[indexDecr.get(j)] = 1;
                    }
                } else {
                    for (int j = 0; j < indexIncr.size(); j++) {
                        f[indexIncr.get(j)] = 1;
                    }
                }
                count++;
            }
        }
    }

    public List<Integer> countNum(int[] seq, boolean flag) {
        int c = 0;
        int j = -1;
        for (int i = 0; i < seq.length; i++) {
            if (f[i] != 1) {
                c = seq[i];
                j = i;
                break;
            }
        }
        if (j == -1) {
            return null;
        }
        List<Integer> index = new ArrayList<>();
        index.add(j);
        for (int i = j + 1; i < seq.length; i++) {
            if (f[i] == 1) continue;
            else {
                if (flag) {
                    if (seq[i] > c) {
                        c = seq[i];
                        index.add(i);
                    }
                } else {
                    if (seq[i] < c) {
                        c = seq[i];
                        index.add(i);
                    }
                }
            }
        }
        return index;
    }
}
