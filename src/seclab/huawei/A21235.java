package seclab.huawei;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/19
 * Time: 13:34
 * Description:
 */
public class A21235 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println(reverse(str));
        }
    }

    public static char[] reverse(String str){
        int i = 0, j = str.length() - 1;
        char c[] = str.toCharArray();
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }

        return c;
    }
}