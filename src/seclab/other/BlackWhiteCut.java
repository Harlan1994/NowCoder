package seclab.other;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/8
 * Time: 16:39
 * Description:
 */
public class BlackWhiteCut {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            System.out.println(longest(input));
        }
    }

    public static int longest(String input) {

        int blackLength = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'b') {
                blackLength++;
            }
        }

        int whiteLength = input.length() - blackLength;

        if (whiteLength < blackLength) {
            return whiteLength * 2 + 1;
        } else {
            return blackLength * 2 + 1;
        }
    }
}
