package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/17
 * Time: 11:29
 * Description:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * Solution:
 * B[i]的值可以看作下图的矩阵中每行的乘积。
 * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 */
public class B11204_构建乘积数组 {

    public int[] multiply(int[] A) {
        int B[] = new int[A.length];

        if (A != null && A.length != 0) {
            B[0] = 1; // 先计算第一个位置

            // 上三角每一个B[i]都等于B[i-1] * A[i-1]
            for (int i = 1; i < A.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }

            // 其实B[n-1]已经算完了

            int temp = 1;

            // 继续计算上三角， n-2开始
            for (int j = A.length - 2; j >= 0; j--) {
                temp *= A[j + 1]; // 先计算B[j]需要乘的数，按照规律等于1，从下到上从右往左乘，即1 * A[n-1] * A[n-2]....*A[1] * A[0] (A[0] = 1)
                B[j] *= temp;
            }
        }
        return B;
    }
}
