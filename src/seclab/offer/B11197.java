package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/9
 * Time: 13:54
 * Description:
 */
public class B11197 {
    public static String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }

        String[] splits = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            if (i < splits.length - 1) {
                sb.append(" " + splits[i]);
            } else {
                sb.append(splits[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String result = ReverseSentence("I am a student.");
        System.out.println(result);
    }
}
