package seclab.alibaba2018;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/7
 * Time: 19:27
 * Description:
 */
public class RemoveDuplicateStr {

    public static void main(String[] args) {
        System.out.println(removeDupStr("刚才我说了我要退款我要退款我要退款我都说了我要退款"));
    }

    public static String removeDupStr(String plainText) {

        StringBuilder stringBuilder = new StringBuilder(plainText);

        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) > '0' && plainText.charAt(i) < '9') {
                continue;
            }
            for (int j = i + 1; j < plainText.length(); j++) {
                if (plainText.charAt(i) == plainText.charAt(j)) {
                    if (j - i > 1) { // 必须大于一位
                        if (j - i > 1 && (2 * j - i) <= plainText.length()) {
                            if (plainText.substring(i, j).equals(plainText.substring(j, 2 * j - i))) {
                                // 此时应该已经找出了一个重复的，只需要删掉它即可
                                stringBuilder.replace(i, j, "");
                                // 然后重新开始
                                plainText = new String(stringBuilder);
                                i = 0;
                            }
                        }
                    }
                }
            }
        }
        return plainText;
    }
}
