package seclab.netease2018;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/27
 * Time: 19:48
 * Description: 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 */
public class AverageSplitsLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> map = new HashMap<>();

        int i = 0;
        int j = i + 1;

        while (j < input.length()) {
            if (input.charAt(j) == input.charAt(i)) {
                j++;
            } else {
                if (map.containsKey(input.substring(i, j))) {
                    map.put(input.substring(i, j), map.get(input.substring(i, j)) + 1);
                } else {
                    map.put(input.substring(i, j), 1);
                }
                i = j;
                j = i + 1;
            }
        }
        // 最后一组没有加上去
        if (map.containsKey(input.substring(i, j))) {
            map.put(input.substring(i, j), map.get(input.substring(i, j)) + 1);
        } else {
            map.put(input.substring(i, j), 1);
        }

        double avg = input.length() * 1.0f / map.size() * 1.0f;
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);
        String result = format.format(avg);
        System.out.println(result);
    }
}
