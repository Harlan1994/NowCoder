package seclab.other;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/16
 * Time: 10:50
 * Description:
 */
public class H01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] map = new int[n][n];
        for (int i = 0; i < m; i++) {
            String[] uv = scanner.nextLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            if(u == v)continue;
            map[u - 1][v - 1] = 1;
        }

        int[] countFrom = new int[n]; // 记录从其余节点到达某个特定节点的可达性，可达加1
        int[] countTo = new int[n]; // 记录某个节点去其他节点的可达节点数

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            DFS(i, n, map, visited);
            int countToNum = 0;
            for (int x = 0; x < n; x++) {
                if (visited[x]) { // 说明从i节点到x节点可达，包括自身
                    if (x != i) { // 去除自身的记录
                        countToNum++; // 可达的节点数+1
                        countFrom[x]++; // 到x的节点数量加1
                    }
                }
            }
            countTo[i] = countToNum;

            if (map[i][i] == 1) { // 如果可自达
                countFrom[i]++;
                countTo[i]++;
            }
        }


        int res = 0;

        for (int i = 0; i < n; i++) {
            if (countTo[i] > countFrom[i]) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static void DFS(int start, int N, int[][] matrix, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < N; i++) {
            if (matrix[start][i] == 1 && !visited[i]) { // 找到邻居节点,并且没有遍历过
                DFS(i, N, matrix, visited);
            }
        }
    }
}
