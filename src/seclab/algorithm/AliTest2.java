package seclab.algorithm;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/22
 * Time: 16:25
 * Description: 光明小学的小朋友举行一年一度的接力跑大赛，遇到一个难题。
 * <p>
 * 要求：把任意两点间经过M条边的最短路径的距离输出来。
 */
public class AliTest2 {

    public static void main(String[] args) {
        AliTest2 aliTest2 = new AliTest2();
        int N, M;
        int[][] map;
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine().trim());
        M = Integer.parseInt(scanner.nextLine().trim());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                String[] elems = line.split(" ");
                map[i][j] = Integer.parseInt(elems[j]);
            }
        }
        int[][] result = aliTest2.solve(N, M, map);
    }

    int[][] solve(int N, int M, int[][] map) {

        int[][] result = new int[N][N];

        // 两个for循环，计算两两之间只有两条路径的路径中最短的那一条
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int[][] visited = new int[N][N];
                int minPath = Integer.MAX_VALUE;
                result[i][j] = dfs(i, j, 0, M, map, visited, minPath);
            }
        }
        return result;
    }

    /**
     * 从起始点开始对整个图进行深度优先遍历，当
     * @param start 起始点
     * @param end 结束点
     * @param currentPathNum 当前的路径条数
     * @param M 目标条数
     * @param map 图的领接矩阵
     * @param visited 图的遍历情况
     * @param minPath 当前最小路径
     * @return 起始点到结束点的最短距离
     */
    int dfs(int start, int end, int currentPathNum, int M, int[][] map, int[][] visited, int minPath) {
        return 0;
    }
}
