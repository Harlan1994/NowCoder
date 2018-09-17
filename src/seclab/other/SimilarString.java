package seclab.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/9
 * Time: 19:55
 * Description:
 */
public class SimilarString {

    private static Map<Character, Integer> characterIntegerMap = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            characterIntegerMap.put((char) (97 + i), i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String target = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            String temp1 = source.substring(i, i + target.length());
            if (similar(temp1, target)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean similar(String source, String target) {
        if (source.length() != target.length()) return false;
        char[] charArray = source.toCharArray();
        for (int i = 0; i < source.length(); i++) {
            charArray[i] = target.charAt(characterIntegerMap.get(charArray[i]));
        }
        if (new String(charArray).equals(target)) {
            return true;
        }
        return false;
    }
}
