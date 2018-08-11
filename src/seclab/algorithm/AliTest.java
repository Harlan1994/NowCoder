package seclab.algorithm;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/18
 * Time: 18:38
 * Description:
 * 如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，才能完成最短路程的派送。
 * 假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 * 输入
 * 4
 * 2,2
 * 2,8
 * 4,4
 * 7,2
 * 输出30
 * 输入
 * 2,2
 * 2,8
 * 6,6
 * 输出28
 */
public class AliTest {

    static final Point START_POINT = new Point(0, 0);

    static int minPath = Integer.MAX_VALUE; //  表示从起始点到最后回归到起始点的距离最小值

    static Point[] pointArray = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        pointArray = new Point[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] lines = line.split(",");
            int x = Integer.parseInt(lines[0]);
            int y = Integer.parseInt(lines[1]);
            pointArray[i] = new Point(x, y);
        }
        int minPath = dfs(START_POINT, 0, 0);
        System.out.println(minPath);
    }

    static int dfs(Point point, int count, int sum) {
        if (count == pointArray.length) { // 如果已经走遍了所有的节点，计算最小路径
            // 当前路径只和加上回到原点的距离和当前最小距离比较，取较小值
            minPath = Math.min(minPath, sum + point.getLength(START_POINT));
            return minPath;
        } else { // 否则继续遍历
            for (int i = 0; i < pointArray.length; i++) {
                if (!pointArray[i].visited) { // 如果还没遍历
                    sum += pointArray[i].getLength(point); // 计算当前点到下一个节点的距离
                    if(sum < minPath) {
                        pointArray[i].visited = true;
                        dfs(pointArray[i], count + 1, sum);
                    }
                    // 回溯
                    sum -= pointArray[i].getLength(point);
                    pointArray[i].visited = false;
                }
            }
        }
        return minPath;
    }

    static class Point {
        int x;
        int y;
        boolean visited = false;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getLength(Point p) {
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }
    }
}
