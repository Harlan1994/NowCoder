package seclab.bytedance;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/9
 * Time: 10:14
 * Description:
 */
public class Solution5 {

    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        M = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[N][N];
        int[] count = new int[N];
        String[] relations = scanner.nextLine().split(" ");
        for (int i = 0; i < M + 2; i+=2) {
            int A = Integer.parseInt(relations[i]);
            int B = Integer.parseInt(relations[i + 1]);
            matrix[A - 1][B - 1] = 1;
        }

        int total = 0;
        // 开始遍历每一个节点
        for (int i = 0; i < N; i++) {

            boolean[] visited = new boolean[N];
            DFS(i, N, matrix, visited);

            for (int x = 0; x < N; x++) {
                System.out.print(visited[x] + " ");
            }

            System.out.println();

            for (int x = 0; x < N; x++) {
                if (visited[x]) { // 说明i节点到该节点可达，可达该节点的节点+1
                    count[x]++;
                }
            }
        }

        for (int x = 0; x < N; x++) {
            if (count[x] == N) {
                total++;
            }
        }

        System.out.println(total);
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
