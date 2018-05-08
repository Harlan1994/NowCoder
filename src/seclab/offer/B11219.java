package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/5
 * Time: 19:07
 * Description:地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class B11219 {

    public static void main(String[] args) {
        int count = movingCount(18, 5, 6);
        System.out.println(count);
    }

    public static int movingCount(int threshold, int rows, int cols) {
        int x = 0;
        int y = 0;
        int[][] flag = new int[rows][cols];
        int count = move(threshold, rows, cols, x, y, flag);
        return count;
    }

    public static int move(int threshold, int rows, int cols, int x, int y, int[][] flag) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || flag[x][y] == 1) {
            return 0;
        }

        flag[x][y] = 1;

        int sum = 0;
        int tmpX = x;
        int tmpY = y;
        while (tmpX > 0) {
            sum += (tmpX % 10);
            tmpX /= 10;
        }

        while (tmpY > 0) {
            sum += (tmpY % 10);
            tmpY /= 10;
        }

        if (sum > threshold) {
            return 0;
        }

        return move(threshold, rows, cols, x + 1, y, flag) +
                move(threshold, rows, cols, x - 1, y, flag) +
                move(threshold, rows, cols, x, y + 1, flag) +
                move(threshold, rows, cols, x, y - 1, flag) + 1;
    }
}
