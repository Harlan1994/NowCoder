package seclab.other;

import java.util.*;

/**
 * User: Harlan1994
 * Date: 2017/9/24
 * Time: 13:08
 * Description:
 */
public class Huawei01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();

        String[] numStrs = nums.split(" ");
        List<NumStr> strs = new ArrayList<>();
        for (String string : numStrs) {
            strs.add(new NumStr(string));
        }

        Collections.sort(strs, Comparator.comparingInt(o -> o.integer));
        int point = scanner.nextInt();

        System.out.println(strs.get(point - 1).getString());
    }

    static class NumStr {

        private Integer integer;
        private String string;

        public NumStr(String num) {
            this.string = num;
            int length = this.string.length();
            this.integer = length > 3 ? new Integer(this.string.substring(length - 3)) : new Integer(this.string);
        }

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }
}