package seclab.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/26
 * Time: 09:04
 * Description:
 */
public class B11187 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }

    public static int FirstNotRepeatingChar(String str) {


        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) == null ? 1 : map.get(str.charAt(i)) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
