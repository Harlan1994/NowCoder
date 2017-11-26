package seclab.other;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/9/25
 * Time: 19:49
 * Description:
 */
public class DiERTi {

    public static void main(String[] args) {
        final String[] nums = {"0", "1", "6", "8"};
        final String[] reverse = {"0", "1", "9", "8"};

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String min = getMin(n);
        String max = getMax(n);

        Long minInt = Long.valueOf(min);
        Long maxInt = Long.valueOf(max);

        StringBuilder stringBuilder = new StringBuilder();
        String strI = null;
        for (Long i = minInt; i <= maxInt; i++) {
            StringBuilder sb = new StringBuilder(i.toString());
            strI = sb.reverse().toString();
            if (!containsUnwanted(strI)) {
                for (int x = 0; x < strI.length(); x++) {
                    if (strI.charAt(x) == '6') {
                        stringBuilder.append("9");
                    } else {
                        stringBuilder.append(strI.charAt(x));
                    }
                }
                if (stringBuilder.reverse().toString().equals(strI)) {
                    System.out.println(strI);
                }
            }
        }
    }

    static boolean containsUnwanted(String string) {
        return string.contains("2") || string.contains("3") || string.contains("4") || string.contains("5") || string.contains("7");
    }

    static String getMin(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        if(n == 1)
        stringBuilder.append("1");
        for (int i = 0; i < n - 1; i++) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    static String getMax(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("9");
        }
        return stringBuilder.toString();
    }
}