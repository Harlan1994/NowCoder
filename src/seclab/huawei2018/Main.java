package seclab.huawei2018;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        find(str);
    }

    private static void find(String s) {
        Stack<Character> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    count += 2;
                } else {
                    count = 0;
                }
                list.add(count);
            } else if (ch != '(' || ch != ')') { //遇到非（）
                if (count != 0) {
                    list.add(count);
                    count = 0;
                }
                if (!stack.isEmpty()) {
                    stack.clear();
                }
            } else if (count != 0 && stack.isEmpty()) {
                list.add(count);
            }
        }
        System.out.println(Collections.max(list));
    }
}