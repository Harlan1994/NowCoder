package seclab.zsyh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/16
 * Time: 20:02
 * Description:
 */
public class ZSYH01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> taste = new ArrayList<>();
        List<Integer> candy = new ArrayList<>();

        // 胃口
        String[] tasteList = scanner.nextLine().split(" ");
        for (int i = 0; i < tasteList.length; i++) {
            taste.add(Integer.parseInt(tasteList[i]));
        }

        // 糖果
        String[] candyList = scanner.nextLine().split(" ");
        for (int i = 0; i < candyList.length; i++) {
            candy.add(Integer.parseInt(candyList[i]));
        }

        // 对他们从小到大排序
        Collections.sort(taste);
        Collections.sort(candy);

        int count = 0;
        for (int i = 0; i < taste.size(); i++) {
            int tasteSize = taste.get(i); // 胃口值
            int j = candy.size() - 1;
            while (j >= 0) { // 找出符合胃口值的最大糖果
                if (candy.get(j) >= tasteSize) {
                    count++;
                    candy.remove(j);
                    break;
                }
                j--;
            }
        }
        System.out.println(count);
    }
}
