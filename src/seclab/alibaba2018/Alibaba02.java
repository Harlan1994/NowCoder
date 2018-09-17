package seclab.alibaba2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/7
 * Time: 19:50
 * Description:
 */
public class Alibaba02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String[] points = scanner.nextLine().split(",");
            Point me = new Point();
            me.x = Integer.parseInt(points[0]);
            me.y = Integer.parseInt(points[1]);

            List<Point> polygon = new ArrayList<>();
            String[] polygonPoints = scanner.nextLine().split(",");
            for (int i = 0; i < polygonPoints.length; i += 2) {
                Point point = new Point();
                point.x = Integer.parseInt(polygonPoints[i]);
                point.y = Integer.parseInt(polygonPoints[i + 1]);
                polygon.add(point);
            }

            if (contains(polygon, me) || containsBoundary(polygon, me)) {
                System.out.println("yes,0");
            } else {
                System.out.println("no," + calculateMinDis(polygon, me));
            }
        }
    }


    static class Point {
        int x;
        int y;
    }

    /**
     * 判断一个点是否在多边形的内部，不包含边上
     * @param polygon
     * @param point
     * @return
     */
    public static boolean contains(List<Point> polygon, Point point) {
        int crossPoints = 0;
        for (int i = 0; i < polygon.size(); i++) {
            Point p1 = polygon.get(i);
            Point p2 = polygon.get((i + 1) % polygon.size());
            if (p1.y == p2.y)
                continue;
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            if (point.y >= Math.max(p1.y, p2.y))
                continue;
            double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
            if (x > point.x)
                crossPoints++;
        }
        return (crossPoints % 2 == 1);
    }

    /**
     * 判断一个点是否在多边形的边上
     * @param polygon
     * @param point
     * @return
     */
    public static boolean containsBoundary(List<Point> polygon, Point point) {
        for (int i = 0; i < polygon.size(); i++) {
            Point p1 = polygon.get(i);
            Point p2 = polygon.get((i + 1) % polygon.size());
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            if (point.y > Math.max(p1.y, p2.y))
                continue;

            if (p1.y == p2.y) {
                double minX = Math.min(p1.x, p2.x);
                double maxX = Math.max(p1.x, p2.x);
                if ((point.y == p1.y) && (point.x >= minX && point.x <= maxX)) {
                    return true;
                }
            } else { // 求解交点
                double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
                if (x == point.x)
                    return true;
            }
        }
        return false;
    }

    /**
     * 计算一个点到多边形的最小距离
     * 计算每一条线段到点的距离，取最短的那条就可以
     * @param polygon
     * @param point
     * @return
     */
    public static int calculateMinDis(List<Point> polygon, Point point) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < polygon.size(); i++) {

            // 随意取一条边，求解到point的距离
            Point p1 = polygon.get(i);
            Point p2 = polygon.get((i + 1) % polygon.size());

            int curDis = calculateDisFromPointToEdge(point, p1, p2);
            if (curDis < min) {
                min = curDis;
            }
        }
        return min;
    }

    /**
     * 计算一个点p到线段ab的距离
     * @param p
     * @param a
     * @param b
     * @return
     */
    public static int calculateDisFromPointToEdge(Point p, Point a, Point b) {
        // ab的距离
        int[] ab = new int[2];
        ab[0] = b.x - a.x;
        ab[1] = b.y - a.y;

        // a me的距离
        int[] ap = new int[2];
        ap[0] = p.x - a.x;
        ap[1] = p.y - a.y;

        int ab_ap = ab[0] * ap[0] + ab[1] * ap[1];
        int distAb2 = ab[0] * ab[0] + ab[1] * ab[1];

        int[] d = new int[]{a.x, a.y};

        if (distAb2 != 0) {
            int t = ab_ap / distAb2;
            if (t > 1) {
                d[0] = b.x;
                d[1] = b.y;
            } else if (t > 0) {
                d[0] = a.x + ab[0] * t;
                d[1] = a.y + ab[1] * t;
            } else {
                d[0] = a.x;
                d[1] = a.y;
            }
        }

        int[] ad = new int[]{p.x - a.x, p.y - a.y};

        return (int) Math.round(Math.sqrt(ad[0] * ad[0] + ad[1] * ad[1]));
    }
}
