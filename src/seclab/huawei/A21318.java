package seclab.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/24
 * Time: 20:55
 * Description:
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“
 */
public class A21318 {

    private static Map<String, String> map = new HashMap<>();

//    public static final String[] numbers = new String[]{"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾", "佰", "仟", "万", "亿", "元", "角", "分", "零"};

    static {
        map.put("1", "壹");
        map.put("2", "贰");
        map.put("3", "叁");
        map.put("4", "肆");
        map.put("5", "伍");
        map.put("6", "陆");
        map.put("7", "柒");
        map.put("8", "捌");
        map.put("9", "玖");
        map.put("10", "拾");
        map.put("100", "佰");
        map.put("1000", "仟");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();

            // 先处理前置和后置零
            String result = printInZh(next);
        }
    }

    static String printInZh(String source) {
        if (source.length() <= 0) return null;
        if (source.equals("0")) {
            System.out.println("零元整");
        }
        source = trimZero(source);
        return "";
    }

    // 去掉前指令和后置零
    static String trimZero(String source) {
        int i = 0;
        while (source.charAt(i) == '0') {
            i++;
        }
        source = source.substring(i);
        i = source.length() - 1;
        while (source.charAt(i) == '0') {
            i--;
        }
        source = source.substring(0, i + 1);
        return source;
    }
}
