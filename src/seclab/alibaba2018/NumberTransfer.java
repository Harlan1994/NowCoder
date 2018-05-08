package seclab.alibaba2018;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/17
 * Time: 16:45
 * Description:
 */
public class NumberTransfer {

    static HashMap<Integer, String> integerStringMap = new HashMap<>();

    static String tansform(long number) {

        integerStringMap.put(1, "一");
        integerStringMap.put(2, "二");
        integerStringMap.put(3, "三");
        integerStringMap.put(4, "四");
        integerStringMap.put(5, "五");
        integerStringMap.put(6, "六");
        integerStringMap.put(7, "七");
        integerStringMap.put(8, "八");
        integerStringMap.put(9, "九");

        long left = number;
        String numberStr = String.valueOf(left);
        StringBuilder stringBuilder = new StringBuilder();


        // 将数字分成三段
        String[] splits = new String[3];
        if (numberStr.length() > 8) {
            splits[0] = numberStr.substring(0, numberStr.length() - 8);
            splits[1] = numberStr.substring(splits[0].length(), numberStr.length() - 4);
            splits[2] = numberStr.substring(splits[0].length() + splits[1].length(), numberStr.length());
//            System.out.println(splits[0] + " " + splits[1] + " " + splits[2]);

            stringBuilder.append(get(splits[0]));
            stringBuilder.append("亿，");

            stringBuilder.append(get(splits[1]));
            stringBuilder.append("万，");

            stringBuilder.append(get(splits[2]));
        } else if (numberStr.length() > 4) {
            splits[0] = numberStr.substring(0, numberStr.length() - 4);
            splits[1] = numberStr.substring(splits[0].length(), numberStr.length());

            stringBuilder.append(get(splits[0]));
            stringBuilder.append("万，");

            stringBuilder.append(get(splits[1]));
        } else {
            splits[0] = numberStr.substring(0, numberStr.length());
            stringBuilder.append(get(splits[0]));
        }

        return stringBuilder.toString();
    }

    static String get(String number) {

        StringBuilder stringBuilder = new StringBuilder();
        int num = Integer.parseInt(number);


        // 去掉前置零
        int zeroIndex = 0;
        while (number.charAt(zeroIndex) == '0') {
            zeroIndex++;
        }

        String tmp = number.substring(zeroIndex, number.length());
        if (tmp.length() == 1) {
            stringBuilder.append(integerStringMap.get(num));
        } else if (tmp.length() == 2) {
            if (tmp.charAt(0) == '1')
                if (tmp.charAt(1) != '0')
                    stringBuilder.append("十" + integerStringMap.get(num % 10));
                else
                    stringBuilder.append("十");
            else
                stringBuilder.append(integerStringMap.get(num / 10) + "十" + integerStringMap.get(num % 10));
        } else if (tmp.length() == 3) {
            stringBuilder.append(integerStringMap.get(num / 100) + "百");
            num %= 100;

            // 剩余两位的操作
            if (num == 0) { // 后两位都是0

            } else { // 后两位至少一位不是0
                if (num < 10) { // 最后一位不是0，第二位是0
                    stringBuilder.append("零" + integerStringMap.get(num));
                } else { // 后两位第一位不是0
                    stringBuilder.append(integerStringMap.get(num / 10) + "十");
                    num %= 10;
                    if (num != 0) { // 最后一位也不等于0
                        stringBuilder.append(integerStringMap.get(num));
                    }
                }
            }

        } else {
            // 第一位肯定不是0
            stringBuilder.append(integerStringMap.get(num / 1000) + "千");
            num %= 1000;

            if (num == 0) { // 后三位都是0

            } else {
                if (num < 10) { // 中间两位都是0，最后一位不是0
                    stringBuilder.append("零" + integerStringMap.get(num));
                } else if (num < 100) { // 第二位是0，第三位肯定不是0，第四位不确定
                    stringBuilder.append("零");
                    stringBuilder.append(integerStringMap.get(num / 10) + "十");
                    num %= 10;
                    if (num != 0) {
                        stringBuilder.append(integerStringMap.get(num));
                    }
                } else { // 第二位肯定不是0，第三第四位不确定
                    stringBuilder.append(integerStringMap.get(num / 100) + "百");
                    num %= 100;
                    // 剩余两位的操作
                    if (num / 10 > 0) { // 后两位第一位不是0
                        stringBuilder.append(integerStringMap.get(num / 10) + "十");
                        num %= 10;
                        if (num != 0) { // 最后一位也不等于0
                            stringBuilder.append(integerStringMap.get(num));
                        }
                    } else { // 后两位第一位是0，此时需要判断第二位是否位0，不然可能多添加了"零"
                        if (num != 0) { // 最后一位不等于0
                            stringBuilder.append("零" + integerStringMap.get(num));
                        }
                    }
                }
            }

        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long number = scanner.nextLong();
            System.out.println(tansform(number));
        }
    }
}