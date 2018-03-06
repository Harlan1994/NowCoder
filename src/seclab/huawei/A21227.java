package seclab.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/6
 * Time: 20:39
 * Description:•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class A21227 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            List<String> strings = new ArrayList<>();
            if (string.length() > 8) {
                int num = string.length() / 8;
                for (int i = 0; i < num; i++) {
                    strings.add(string.substring(i * 8, i * 8 + 8));
                }
                if(num * 8 != string.length()) {
                    String lastStr = string.substring(num * 8, string.length());
                    StringBuffer sb = new StringBuffer(lastStr);
                    while (sb.length() != 8) {
                        sb.append('0');
                    }
                    strings.add(sb.toString());
                }
            } else if (string.length() == 8) {
                strings.add(string);
            } else {
                StringBuffer sb = new StringBuffer(string);
                while (sb.length() != 8) {
                    sb.append('0');
                }
                strings.add(sb.toString());
            }

            for (String str : strings) {
                System.out.println(str);
            }
        }
    }
}
