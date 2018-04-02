package seclab.netease2018;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/27
 * Time: 19:38
 * Description: 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
 * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
 * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
 * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
 *
 * state: Accepted
 */
public class MagicCoin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magicCoinNum = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        while (magicCoinNum != 0) {
            if ((magicCoinNum - 1) % 2 == 0) {
                sb.append("1");
                magicCoinNum -= 1;
                magicCoinNum /= 2;
            } else {
                sb.append("2");
                magicCoinNum -= 2;
                magicCoinNum /= 2;
            }
        }

        System.out.println(sb.reverse().toString());
    }
}
