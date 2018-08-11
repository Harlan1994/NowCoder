package seclab.pingduoduo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/5
 * Time: 18:57
 * Description:
 */
public class Ping03 {

    public static void main(String[] args) {
        Ping03 ping03 = new Ping03();
        ping03.test();
    }

    public void test() {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int seqOfUser = Integer.parseInt(splits[1]);

        Set<Integer> friendOfCurrent = new HashSet<>();

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] splitFriends = scanner.nextLine().split(" ");
            for (int j = 0; j < splitFriends.length; j++) {
                int friend = Integer.parseInt(splitFriends[j]);
                map[i][friend] = 1; // j是i的朋友
                map[friend][i] = 1; // 同样i也是j的朋友

                if (i == seqOfUser) { // 添加 seqOfUser的好友列表
                    friendOfCurrent.add(friend);
                }
            }
        }

        Set<Integer> friendOfOther = new HashSet<>();

        int maxCount = 0; // 最多共同好友数
        int seqOfTarget = -1;

        // 找出当前用户的好友
        for (int i = 0; i < N; i++) {
            friendOfOther.clear();
            if (i == seqOfUser) continue;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    friendOfOther.add(j);
                }
            }

            int count = 0;
            for (Integer integer : friendOfCurrent) {
                if (friendOfOther.contains(integer)) {
                    count++;
                }
            }

            if(count > maxCount && map[i][seqOfUser] != 1){
                maxCount = count;
                seqOfTarget = i;
            }
        }

        System.out.println(seqOfTarget);
    }
}


