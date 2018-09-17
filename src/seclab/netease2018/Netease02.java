package seclab.netease2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/11
 * Time: 12:56
 * Description:
 * <p>
 * #include <iostream>
 * #include <vector>
 * #include <stdio.h>
 * <p>
 * using namespace std;
 * <p>
 * int main() {
 * int n, m;
 * cin >> n;
 * vector<int> apples, query;
 * int tmp;
 * int middle_sum = 0;
 * for (int i = 0; i < n; i++) {
 * scanf("%d", &tmp);
 * middle_sum += tmp;
 * apples.push_back(middle_sum);
 * }
 * cin >> m;
 * for (int i = 0; i < m; i++) {
 * scanf("%d", &tmp);
 * query.push_back(tmp);
 * }
 * <p>
 * vector<int> res;
 * bool flag = true;
 * for (int i = 0; i < m; i++) {
 * int left = 0, right = n - 1;
 * while (left <= right) {
 * int mid = left + (right - left) / 2;
 * if (query[i] == apples[mid]) {
 * flag = false;
 * res.push_back(mid + 1);
 * break;
 * } else if (query[i] > apples[mid]) {
 * left = mid + 1;
 * } else {
 * right = mid - 1;
 * }
 * }
 * <p>
 * if (flag) {
 * res.push_back(left + 1);
 * } else{
 * flag = true;
 * }
 * }
 * <p>
 * <p>
 * for (auto x : res) {
 * cout << x << endl;
 * }
 * <p>
 * return 0;
 * }
 */
public class Netease02 {

    public static void main(String[] args) {
        Netease02 netease02 = new Netease02();
        netease02.test();
    }

    public void test() {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] a = new int[n];
        String[] splits = scanner.nextLine().split(" ");
        int sum = 0;
        List<String> appleMiddle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(splits[i]);
            sum += a[i];
            appleMiddle.add(sum + "");
        }
        int m = Integer.parseInt(scanner.nextLine());
        String[] splitsQ = scanner.nextLine().split(" ");

        boolean flag = true;

        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            int q = Integer.parseInt(splitsQ[i]);
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (q == Integer.parseInt(appleMiddle.get(mid))) {
                    flag = false;
                    res.add((mid + 1) + "");
                    break;
                } else if (q > Integer.parseInt(appleMiddle.get(mid))) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (flag) {
                res.add((left + 1) + "");
            } else {
                flag = true;
            }
        }
        for (String integer : res) {
            System.out.println(integer);
        }
    }
}

