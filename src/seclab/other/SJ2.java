package seclab.other;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * User: Harlan1994
 * Date: 2017/9/9
 * Time: 16:32
 * Description:
 */
public class SJ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Set<String> set = new HashSet<>();

        int i = 0, j = i + 1;
        while (i < str.length() && j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) j++;
            else {
                if (!set.contains(str.substring(i, j)))
                    set.add(str.substring(i, j));
                i = j;
            }
        }
        if (!set.contains(str.substring(i, j)))
            set.add(str.substring(i, j));
        int sum = 0;
        for (String s : set) {
            sum += s.length();
        }
        int avgLength = sum / set.size();
        System.out.println(avgLength);
    }
}