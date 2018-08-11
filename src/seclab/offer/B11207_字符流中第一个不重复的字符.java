package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/17
 * Time: 18:33
 * Description:请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class B11207_字符流中第一个不重复的字符 {

    private int[] charFlags = new int[256];
    private int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charFlags[ch] == 0) { // 没有出现过，也就是只出现过一次
            charFlags[ch] = index;
        } else { // 进来过
            charFlags[ch] = -2;
        }
        index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char result = '#';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (charFlags[i] > 0 && minIndex > charFlags[i]) { // 如果出现过一次，只需要找出index最小的即可
                result = (char) i;
                minIndex = charFlags[i];
            }
        }
        return result;
    }
}
