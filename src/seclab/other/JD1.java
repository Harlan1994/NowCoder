package seclab.other;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Stack;

/**
 * User: Harlan1994
 * Date: 2017/9/8
 * Time: 19:35
 * Description:
 */
public class JD1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push('(');
            } else {

            }
        }
    }
}