package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/15
 * Time: 11:17
 * Description:LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class B11198_扑克牌顺子 {

    public static boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;

        // 找到最小的以及0的个数
        int zeroCount = 0;
        int min = 14;
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
                continue;
            }
            if (numbers[i] < min) {
                min = numbers[i];
            } else {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }
        }

        if (max - min >= 5) return false;

        // 如果最大值和最小值之间小于5，那么如果不是顺子肯定存在重复的情况
        int[] newNums = new int[numbers.length];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = -1;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                if (newNums[numbers[i] - min] != -1) {
                    return false;
                }
                newNums[numbers[i] - min] = numbers[i];
            } else {
                zeroCount--;
                if (zeroCount < 0) return false;
            }
        }
        return true;
    }

    // flag是多余的，这里用位操作的方法判定是否有重复的，原理如下

    /**
     * 1，numbers可以有0可以代替其他任何牌，numbers length一定是5才可以
     * 2，其他非0的牌之间最大值最小值必须满足max - min < 5
     * 3，其他非0的牌之间，如果在满足max - min < 5的情况下，如果不是顺子，那么一定存在重复的情况
     * 4，如果不重复，说明满足顺子
     *
     * @param numbers
     * @param useless
     * @return
     */
    public static boolean isContinuous(int[] numbers, int useless) {
        int length = numbers.length;
        if (length != 5) return false; // 1

        int min = 14;
        int max = 0;
        byte flag = 0; // 记录8位，每一位初始化为0，表示不存在
        for (int i = 0; i < length; i++) {
            int number = numbers[i];
            if (number == 0) continue;
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5) return false;

            // 如果flag右移number位，和1相与还等于1，说明number已经存在了，有了重复的不行，返回false
            if (((flag >> number) & 1) == 1) return false;
            // 如果不存在,则将flag这个位置标记为存在
            flag |= (1 << number); // 将1左移number位并且和flag或一下，flag的number位置就是1了
        }
        // 转了一圈没发现异常，说明既满足max - min < 5有满足没有重复，这样的话一定是顺子
        return true;
    }

    public static void main(String[] args) {
        boolean flag = isContinuous(new int[]{1, 3, 2, 5, 4}, 1);
        System.out.println(flag);
    }
}
