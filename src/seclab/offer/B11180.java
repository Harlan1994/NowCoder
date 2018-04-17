package seclab.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/17
 * Time: 13:28
 * Description:输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class B11180 {

    public static void main(String[] args) {
        B11180 b11180 = new B11180();
        Scanner scanner = new Scanner(System.in);
        String str;
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            ArrayList<String> strings = b11180.Permutation(str);

            for (String str2 : strings) {
                System.out.print(str2 + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<String> Permutation(String str) {
        TreeSet<String> strings = new TreeSet<>();
        permutaionCore(str.toCharArray(), 0, strings);
        return new ArrayList<>(strings);
    }

    public void permutaionCore(char[] str, int i, TreeSet<String> strings) {
        if (i == str.length - 1) { // 到了最后一个节点
            strings.add(new String(str));
        } else {
            for (int j = i; j < str.length; j++) {
                swap(str, i, j);
                permutaionCore(str, i + 1, strings);
                swap(str, i, j);
            }
        }
    }

    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
