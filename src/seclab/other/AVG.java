package seclab.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/19
 * Time: 21:09
 * Description:
 */
public class AVG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int avg = scanner.nextInt();
        Node[] nodes = new Node[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            int magic = scanner.nextInt();
            nodes[i] = new Node(score, magic);
            sum += nodes[i].score;
        }

        int curAvg = sum / n; // 得分平均

        if (curAvg > r) { // 平均分大于要求的
            System.out.println(0);
            return;
        }

        // 否则计算需要多少分才能达到平均分
        int neededScore = avg * n - sum;

        System.out.println("neededScore = " + neededScore);

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.magic == o2.magic){
                    return o1.score - o2.score;
                }
                return o1.magic - o2.magic;
            }
        });

        int magicValue = 0;

        for (int i = 0; i < n; i++) {
            if (neededScore <= 0) break;
            if (nodes[i].score < r) {
                while (nodes[i].score < r) {
                    magicValue += nodes[i].magic;
                    nodes[i].score++;
                    neededScore--;
                    if(neededScore <= 0)break;
                }
            }
        }

        System.out.println(magicValue);
    }

    static class Node {
        int score;
        int magic;

        public Node(int score, int magic) {
            this.score = score;
            this.magic = magic;
        }
    }
}