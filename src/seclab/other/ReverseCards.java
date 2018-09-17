package seclab.other;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/8
 * Time: 16:27
 * Description:
 * <p>
 * 翻转牌，其周围的8张牌也跟着翻转，问操作后有几张翻转了
 * 求翻转所有的牌后剩下几张牌翻转了
 */
public class ReverseCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            long N, M;
            String[] NM = scanner.nextLine().split(" ");
            N = Long.parseLong(NM[0]);
            M = Long.parseLong(NM[1]);
            System.out.println(Math.abs(N * M - N * 2 - (M - 2) * 2));
        }
    }
}
