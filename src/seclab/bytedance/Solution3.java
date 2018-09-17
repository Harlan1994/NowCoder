package seclab.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/9
 * Time: 10:14
 * Description:
 */
public class Solution3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        List<String> result = restoreIpAddresses(s);
        System.out.println(result.size());
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String temp = new String();
        find(s, temp, result, 4, 0, s.length());
        return result;
    }

    public static void find(String s, String temp, List<String> result, int count, int index, int len) {
        if (count == 0 && index == len) {
            result.add(temp);
            return;
        }
        if ((count == 0 && index < len) || (count > 0 && index == len)) {
            return;
        }

        int value = 0;
        boolean flag = true;
        while (index < len && flag) {
            if (value == 0 && s.charAt(index) == '0') {
                flag = false;
            }
            value = value * 10 + s.charAt(index) - '0';
            index++;
            if (value < 256) {
                String record;
                if (count == 1) {
                    record = temp + Integer.toString(value);
                } else {
                    record = temp + Integer.toString(value) + '.';
                }

                find(s, record, result, count - 1, index, len);
            }
        }
    }
}
