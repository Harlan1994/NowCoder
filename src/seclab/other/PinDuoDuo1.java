package seclab.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/9/2
 * Time: 15:01
 * Description:
 */
public class PinDuoDuo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int panda = scanner.nextInt();
        int candy = scanner.nextInt();
        Integer[] candies = new Integer[candy];
        Panda[] pandas = new Panda[panda];
        int[] flag = new int[candy];
        for (int i = 0; i < candy; i++) {
            candies[i] = scanner.nextInt();
            flag[i] = 1; // 没有吃
        }

        for (int i = 0; i < panda; i++) {
            pandas[i] = new Panda(i + 1, scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(candies, (o1, o2) -> o2 - o1);
        Arrays.sort(pandas, (p1, p2) -> p2.getFight() - p1.getFight());

        for (int i = 0; i < panda; i++) {
            for (int j = 0; j < candy; j++) {
                if (flag[j] == 1 && candies[j] <= pandas[i].getHungury()) {
                    pandas[i].setHungury(pandas[i].getHungury() - candies[j]);
                    flag[j] = 0; // 被吃了
                    if (pandas[i].getHungury() == 0) break;
                }
            }
        }

        Arrays.sort(pandas, Comparator.comparingInt(Panda::getSeq));

        for (int i = 0; i < panda; i++) {
            System.out.println(pandas[i].getHungury());
        }
    }

    static class Panda {
        int seq;
        int fight;
        int hungury;

        public Panda(int seq, int fight, int hungury) {
            this.seq = seq;
            this.fight = fight;
            this.hungury = hungury;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public int getFight() {
            return fight;
        }

        public void setFight(int fight) {
            this.fight = fight;
        }

        public int getHungury() {
            return hungury;
        }

        public void setHungury(int hungury) {
            this.hungury = hungury;
        }
    }
}