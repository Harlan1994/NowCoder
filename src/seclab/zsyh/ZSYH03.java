package seclab.zsyh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/16
 * Time: 19:39
 * Description:
 */
public class ZSYH03 {

    public static Map<String, String> integerIntegerMap = new HashMap<>();

    static {
        integerIntegerMap.put("6", "9");
        integerIntegerMap.put("9", "6");
        integerIntegerMap.put("8", "8");
        integerIntegerMap.put("1", "1");
        integerIntegerMap.put("2", "5");
        integerIntegerMap.put("5", "2");
        integerIntegerMap.put("0", "0");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        System.out.println(checkNum(Integer.parseInt(N)));
    }

    public static int checkNum(Integer N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isHaoShu(String.valueOf(i))) {
                count++;
                System.out.println(i + "是好数！");
            }
        }
        return count;
    }

    public static boolean isHaoShu(String num) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (!integerIntegerMap.containsKey(c + "")) {
                return false;
            } else {
                stringBuilder.append(integerIntegerMap.get(c + ""));
            }
        }
        if(num.equals(stringBuilder.toString()))return false;
        return true;
    }
}
