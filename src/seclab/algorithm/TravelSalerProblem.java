package seclab.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/16
 * Time: 09:48
 * Description: 旅行售货员问题:某售货员要到若干城市去推销商品，已知各城市之间的路程（旅费），
 * 他要选定一条从驻地出发，经过每个城市一遍，最后回到驻地的路线，使总的路程（总旅费）最小。
 */
public class TravelSalerProblem {

    private static final int N = 4;
    private static final int INF = 0x7fffffff; // 节点之间如果是INF代表没有路径
    private static int[] bestx = new int[N + 1]; // 当前最优路径
    private static int[] x = new int[N + 1];
    private static int bestc = 0;
    private static int[][] matrix = new int[N + 1][N + 1]; // 四个节点的图邻接矩阵
    private static int cost = 0;

    public static void main(String[] args) {

        // 初始化邻接矩阵
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("/Users/harlan/workspace/java/NowCoder/src/seclab/algorithm/TravelSalerProblem.txt")));
            int x = 0, y = 0;
            while (scanner.hasNext()) {
                int tmp = scanner.nextInt();
                matrix[x][y] = tmp == 0 ? INF : tmp;
                y++;
                if (y == N) {
                    y = 0;
                    x++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data read error.");
        }

        // 我们假设预选的路线是 1，2，3，4，1
        for (int i = 1; i <= N; i++) {
            x[i] = i;
        }

        cost = 0;
        bestc = 0;

        // 我们假设初始点是1号，售货员开始走第二个节点（初始点是任何的点都可以，因为最终都要形成一个回路）
        traveling(2);

        // 输出最短回路
        System.out.print("travel cycle is: ");
        for (int i = 1; i <= N; i++) {
            System.out.print(bestx[i] + " ");
        }
        System.out.println(bestx[1]);

        // 输出最小费用
        System.out.println("min cost is: " + bestc);
    }

    static void traveling(int i) {

        // 已经到了最后一个节点
        if (i == N) {
            // 如果当前路径最后两个节点之间存在一条路径并且最后一个节点和第一个节点存在一条路径（形成一条回路）
            // 也就是说，如果递归到了最后一个节点，那么选择还是不选择先看有没有路径以及回去第一个节点的路存不存在（我们已经选定第一个节点是1，并且从2节点开始搜索）
            if (matrix[x[N - 1]][x[N]] != INF && matrix[x[N]][1] != INF) {
                if (bestc == 0 || bestc > (cost + matrix[x[N]][1] + matrix[x[N - 1]][x[N]])) {
                    // 更新当前最优解对应的路径
                    for (int j = 1; j <= N; j++) {
                        bestx[j] = x[j];
                    }
                    bestc = cost + matrix[x[N]][1] + matrix[x[N - 1]][x[N]];
                }
            }
        } else {
            // 遍历解空间，i从2开始
            for (int j = i; j <= N; j++) {
                // matrix[x[i - 1]][x[j]]表示当前节点上一个节点（i-1）到后续节点的距离（cost）
                // 如果存在路径并且耗费小于当前最优解（这样才有必要继续走下去），那么继续递归
                if (matrix[x[i - 1]][x[j]] != INF && (cost + matrix[x[i - 1]][x[i]] < bestc || bestc == 0)) {
                    swap(i, j);
                    System.out.print("hello: ");
                    for (int c = 1; c <= N; c++) {
                        System.out.print(x[c] + " ");
                    }
                    System.out.println("1");
                    cost += matrix[x[i - 1]][x[i]];
                    traveling(i + 1);
                    cost -= matrix[x[i - 1]][x[i]];
                    swap(i, j);
                    System.out.print("world: ");
                    for (int c = 1; c <= N; c++) {
                        System.out.print(x[c] + " ");
                    }
                    System.out.println("1");
                }
            }
        }
    }

    static void swap(int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
}
