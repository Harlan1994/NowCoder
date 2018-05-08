package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/7
 * Time: 21:00
 * Description:请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class B11218 {

    public static void main(String[] args) {
        String s1 = "ABCESFCSADEE";
        char[] matrix = new char[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            matrix[i] = s1.charAt(i);
        }
        String s2 = "SEE";
        char[] str = new char[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            str[i] = s2.charAt(i);
        }

        int rows = 3;
        int cols = 4;

        System.out.println(hasPath(matrix, rows, cols, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                boolean has = false;
                // 每次都是新的，没有遍历过的
                int[] flag = new int[matrix.length];
                // 只要开头相等的，就深度优先搜索有没有路径
                if (matrix[i * cols + j] == str[0]) {
                    System.out.println("A start point found: x = " + i + ", j = " + j);
                    if (hasPathCore(matrix, rows, cols, str, i, j, 0, flag)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int x, int y, int index, int[] flag) {

        if (x < 0 || x >= rows || y < 0 || y >= cols || flag[x * cols + y] == 1 || str[index] != matrix[x * cols + y]) {
            return false;
        }

        // 如果已经匹配到了最后一个字符
        if (index == str.length - 1) return true;

        flag[x * cols + y] = 1; // 记录遍历过了

        // 继续查看下一个字符
        boolean turnUp = hasPathCore(matrix, rows, cols, str, x - 1, y, index + 1, flag);
        boolean turnDown = hasPathCore(matrix, rows, cols, str, x + 1, y, index + 1, flag);
        boolean turnRight = hasPathCore(matrix, rows, cols, str, x, y + 1, index + 1, flag);
        boolean turnLeft = hasPathCore(matrix, rows, cols, str, x, y - 1, index + 1, flag);

        // 只需要其中一条返回true，就说明存在路径，返回true
        return turnDown || turnLeft || turnRight || turnUp;
    }
}
