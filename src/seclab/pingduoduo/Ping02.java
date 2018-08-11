package seclab.pingduoduo;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/5
 * Time: 18:57
 * Description:
 */
public class Ping02 {

    public static void main(String[] args) {
        Ping02 ping02 = new Ping02();
        int result = ping02.test();
        System.out.println(result);
    }

    public int test() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int totalCount = 0;
        // 去掉前置0
//        str = removePreZero(str);
        for (int i = 0; i < str.length() - 1; i++) { // 切分
            String partOne = str.substring(0, i + 1);
            String partTwo = str.substring(i + 1, str.length());

            // 看看两个组合能组成多少组
            int count; // 整数肯定可以成为一组
            if (partOne.charAt(0) == '0' || partTwo.charAt(0) == '0') { // 如果整数前面有前置0，不合法
                count = 0;
            } else {
                count = 1;
            }

            int addPointOne = addPoint(partOne);
            count += addPointOne;

            int addPointTwo = addPoint(partTwo);
            count += addPointTwo;

            count += addPointOne * addPointTwo;
            totalCount += count;
        }

        return totalCount;
    }

    // 计算合法的添加小数点的位置
    public int addPoint(String part) {
        if (part.charAt(0) == '0' && part.charAt(part.length() - 1) != '0') {
            return 1;
        } else {
            return part.length() - 1;
        }
    }

    public String removePreZero(String s) {
        int i = 0;
        while (s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }

    public String removePostZero(String str) {
        int i = str.length() - 1;
        while (str.charAt(i) == '0') {
            i--;
            if (i == -1) return "";
        }
        return str.substring(0, i + 1);
    }
}
