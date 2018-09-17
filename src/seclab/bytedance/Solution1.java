package seclab.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/9
 * Time: 10:09
 * Description:
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(lengthOfLongestSubstring(input));
    }

    /**
     * @param s: a string
     * @return: an integer
     */
    public static int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                int index = list.indexOf(s.charAt(i));
                list = list.subList(index + 1, list.size());
                list.add(s.charAt(i));
                max = Math.max(max, list.size());
            } else {
                list.add(s.charAt(i));
                max = Math.max(max, list.size());
            }
        }
        return max;
    }
}
