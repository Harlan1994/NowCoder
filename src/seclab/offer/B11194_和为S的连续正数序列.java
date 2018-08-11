package seclab.offer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/7
 * Time: 21:05
 * Description:小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class B11194_和为S的连续正数序列 {

    public static void main(String[] args) {
        B11194_和为S的连续正数序列 b11194_和为S的连续正数序列 = new B11194_和为S的连续正数序列();
        ArrayList<ArrayList<Integer>> arrayLists = b11194_和为S的连续正数序列.FindContinuousSequence(3);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * 整体思路：
     * 按照等差数列求和公式: sum = a1*n+n*(n-1)*d/2,
     * 由于d=1，所以简化位 sum = a1*n+n*(n-1)/2,
     * 由于a1*n>=0,所有可以得到sum>=n*(n-1)/2 => n <= sqrt(2*sum),
     * 也就是说n的范围可以确定 2<=n<=sqrt(2*sum)
     * 那我们只需要遍历所有的n的情况，通过n可以求出中间值：
     * （1）n为偶数的情况，平均值就是两个中间值的平均数，Java语言计算出来的是左边这个
     * （2）n为奇数的情况，平均值就是中间的数
     * 知道了中间值或者说知道了平均数，又知道了n那么这个连续序列很快就可以确定。
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        // 默认不能等于0, 1, 2
        if (sum <= 0 || sum == 1 || sum == 2) return arrayList;

        int nMax = (int) Math.sqrt(2 * sum);
        for (int i = nMax; i >= 2; i--) {
            // 如果i是奇数并且sum可以被i整除，那么平均值就是中间的数
            // 如果i是偶数，中间两个数的平均数就是整体的平均数，并且平均数小数是0.5
            // 说明余数是除数的一半
            if ((i & 1) == 1 && (sum % i == 0) || (sum % i) * 2 == i) {
                // 如果是偶数位，那么 sum/i计算出的是左边的那个数字，往前推的
                // 个数和是奇数时一样, 而如果是奇数为 (n-1)/2 == n/2
                int start = sum / i - (i - 1) / 2;
                arrayList.add(createList(start, i));
            }
        }

        return arrayList;
    }

    public ArrayList<Integer> createList(int start, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start, j = 0; j < n; j++, i++) {
            list.add(i);
        }
        return list;
    }
}
