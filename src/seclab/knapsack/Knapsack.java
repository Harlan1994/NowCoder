package seclab.knapsack;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/25
 * Time: 12:11
 * Description:
 */
public class Knapsack {

    /**
     * 01背包问题
     *
     * @return the max value
     */
    public static float knapsack01() {

//        int[] W, V;
//        int C;
//
//        Scanner scanner = new Scanner(System.in);
//
//        /**
//         * inputs
//         */
//
//        // n objects corresponds to n values
//        int n = scanner.nextInt();
//
//        // initialize a n-sized object-value pairs
//        W = new int[n + 1];
//        V = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            W[i] = scanner.nextInt();
//            V[i] = scanner.innextInt();
//        }
//
//        // capacity
//        C = scanner.nextInt();


//        int[] weights = {0, 2, 2, 4, 4, 8};
//        float[] values = {0f, 1f, 0.25f, 0.5f, 0.25f, 1f};
//        int[] nums = {0, 4, 8, 6, 4, 2};

//        int[] weights = {0, 8, 4, 4, 2, 2};
//        float[] values = {0f, 1f, 0.25f, 0.5f, 0.25f, 1f};
//        int[] nums = {0, 2, 4, 6, 8, 4};

        int[] weights = {0, 8, 16, 8, 8, 2};
        float[] values = {0, 1f, 4f, 2f, 4f, 1f};
        int[] nums = {0, 2, 4, 6, 8, 4};

        float sum = 0;
        for (int i = 1; i < values.length; i++) {
            sum += nums[i] * values[i];
        }

        System.out.println("总的values：" + sum);

        int C = 128;

        // 计算有几件物品
        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            n += nums[i];
        }

        System.out.println("Totally " + n + " objects.");

        // 扩充重量,使得相应物品和其重量一一对应
        int[] W = new int[n + 1];
        float[] V = new float[n + 1];

        W[0] = 0;
        V[0] = 0;

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp_num = nums[i];
            int temp_weight = weights[i];
            float temp_value = values[i];
            while (temp_num-- > 0) {
                W[k] = temp_weight;
                V[k] = temp_value;
                k++;
            }
        }

        /**
         * define f[i][v] as the max value for the previous i objects put
         * into a backpack whose capacity is v.
         */
        // initialize f[][]
        float[][] f = new float[n + 1][C + 1];

        // for n objects
        for (int i = 1; i <= n; i++) {
            // for every possible capacity
            for (int j = C; j >= 1; j--) {
                // if current capacity cannot contain i.
                if (j < W[i]) {
                    f[i][j] = f[i - 1][j];
                } else { // else there are two choices.
//                    f[i][j] = max(f[i - 1][j], f[i - 1][j - W[i]] + V[i]);
                    if (f[i - 1][j] > (f[i - 1][j - W[i]] + V[i])) {
                        f[i][j] = f[i - 1][j];
                    } else {
                        f[i][j] = f[i - 1][j - W[i]] + V[i];
                    }
                }
            }
        }

        int weight = C;
        int[] mark = new int[n + 1];

        System.out.println("length "+ n);

        for (int i = n; i > 1; i--) {
            if (f[i][weight] == f[i - 1][weight]) {
                mark[i] = 0;
            } else {
                mark[i] = 1;
                weight = weight - W[i];
            }
        }

        if (f[1][C] == 0) {
            mark[1] = 0;
        } else {
            mark[1] = 1;
        }

        // 打印所有商品的使用情况
        for (int i = 1; i <= n; i++) {
            System.out.print(mark[i] + " ");
        }

        System.out.println();

        int[] used = new int[nums.length];
        used[0] = 0;
        int r = 1;
        int s = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp_num = nums[i];
            while (temp_num-- > 0) {
                if (mark[r++] == 1)
                    used[s]++;
            }
            s++;
        }

        // 打印所有商品使用情况
        for (int i = 1; i < used.length; i++) {
            System.out.println("第" + i + "种商品使用量：" + used[i]);
        }

        /**
         * print the final matrix
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }

        return f[n][C];
    }


    /**
     * 完全背包问题
     *
     * @return the max value
     */
    public static int knapsackComplete() {
        return 1;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static float max(float a, float b) {
        return a > b ? a : b;
    }


    public static void main(String[] args) {
        float value = knapsack01();
        System.out.println("Max value is:" + value);
    }
}


