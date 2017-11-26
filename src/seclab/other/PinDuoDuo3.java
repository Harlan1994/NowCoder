package seclab.other;

import java.util.*;

/**
 * User: Harlan1994
 * Date: 2017/9/2
 * Time: 16:14
 * Description:
 */
public class PinDuoDuo3 {

    private static List<Goods> goods = new ArrayList<>();
    private static List<Activity> activities = new ArrayList<>();

    private static int activityId = 0;

    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] nm = str.split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        for (int i = 0; i < N; i++) {
            str = scanner.nextLine();
            String[] nums = str.split(" ");
            Goods good = new Goods(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]));
            goods.add(good);
        }

        for (int i = 0; i < M; i++) {
            str = scanner.nextLine();
            String[] num = str.split(" ");
            int no = Integer.parseInt(num[0]);
            String op = num[1];

            switch (op) {
                case "buy":
                    int activityId = Integer.parseInt(num[2]);
                    int quantity = Integer.parseInt(num[3]);
                    System.out.println(buyGoods(no, activityId, quantity));
                    break;
                case "add":
                    int startTime = Integer.parseInt(num[2]);
                    int endTime = Integer.parseInt(num[3]);
                    int goodsId = Integer.parseInt(num[4]);
                    int limitQuantity = Integer.parseInt(num[5]);
                    System.out.println(addActivity(startTime, endTime, goodsId, limitQuantity));
                    break;
                case "list":
//                    getActivityList();
                    break;
                default:
                    break;
            }


        }
    }

    public static int buyGoods(int no, int activityId, int quantity) {
        for (Activity activity : activities) {

            if (activity.getEndTime() <= no || activity.getStartTime() > no) return -1;

            if (activity.getId() == activityId) {
                if (quantity <= activity.getLimitQuantity()) {
                    activity.setLimitQuantity(activity.getLimitQuantity() - quantity);
                    return 0;
                }
            }
        }
        return -1;
    }

    public static int addActivity(int startTime, int endTime, int goodsId, int limitQuantity) {
        if (goods.size() < limitQuantity) {
            activities.add(new Activity(startTime, endTime, goodsId, limitQuantity));
            return goodsId;
        }
        return -1;
    }

    static class Goods {
        int id, value, count;

        public Goods(int id, int value, int count) {
            this.id = id;
            this.value = value;
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    static class Activity {

        int id;
        int startTime, endTime, goodsId, limitQuantity;

        public Activity() {

        }

        public Activity(int startTime, int endTime, int goodsId, int limitQuantity) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.goodsId = goodsId;
            this.limitQuantity = limitQuantity;
            this.id = activityId++;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getLimitQuantity() {
            return limitQuantity;
        }

        public void setLimitQuantity(int limitQuantity) {
            this.limitQuantity = limitQuantity;
        }
    }
}