package seclab.other;

/**
 * User: Harlan1994
 * Date: 2017/10/23
 * Time: 19:48
 * Description: 银行坏账
 */
public class BankBadData {

    public static void main(String[] args) {
        System.out.println(new BankBadData().getNext("ababaaababaa"));
    }

    public int[] getNext(String b) {
        int len = b.length();
        int j = 0;

        int next[] = new int[len + 1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0] = next[1] = 0;

        //i表示字符串的下标，从0开始
        for (int i = 1; i < len; i++) {
            //j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            while (j > 0 && b.charAt(i) != b.charAt(j)) {
                j = next[j];
            }
            if (b.charAt(i) == b.charAt(j)) {
                j++;
            }
            next[i + 1] = j;
        }

        return next;
    }
}