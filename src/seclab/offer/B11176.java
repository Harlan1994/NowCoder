package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/8
 * Time: 10:17
 * Description:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class B11176 {

    public static void main(String[] args) {
        int[] sequence = new int[]{5, 4, 3, 2, 1};
        System.out.println(VerifySquenceOfBST(sequence));
    }

    /**
     * 解决方案：一颗搜索二叉树的后续遍历肯定是先遍历左子树、在遍历右子树、然后是根节点，根节点比左子树大、比右子树小
     * 所以sequence左边是左子树中间是右子树，最右边的是根节点、左子树和右子树都有可能为空。
     *
     * 根据以上特点，我们递归判断当前是否满足后续遍历的结果，然后递归判断左右子树的情况即可，只要有一此不满足则不是
     * 1. 先判断是否有左右子树为空的两种情况，这两种比较特殊，如果判断结果满足左右子树为空而且还是满足后续遍历序列
     * 继续递归判断
     * 2. 如果左右子树都不为空，那么只需要定位第一个特殊位置（从右往左第一个比root小的节点），作为分界点，如果继续往左还是
     * 存在比root大的，那肯定不满足，否则当前序列满足，需要递归判断左右子树
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null) return false;
        if (sequence.length <= 0) return false;
        if (sequence.length == 1) return true;
        return verify(sequence, 0, sequence.length - 1);
    }

    public static boolean verify(int[] sequence, int left, int right) {

        if (left >= right) return true; // 递归到最后了还没有返回false，则肯定是了
        int root = sequence[right];

        if (sequence[left] > root) { // 不存在左子树的可能
            for (int i = left + 1; i < right; i++) {
                if (sequence[i] < root) { // 如果存在一个不一样的，则false
                    return false;
                }
            }

            // 否则可能符合，需要继续判断右子树
            return verify(sequence, left, right - 1);
        }

        if (sequence[right - 1] < root) { // 不存在右子树的可能
            for (int i = left + 1; i < right; i++) {
                if (sequence[i] > root) {
                    return false;
                }
            }

            // 否则继续判断左子树
            return verify(sequence, left, right - 1);
        }

        // 左子树右子树都有
        int j = right - 1;
        while (sequence[j] > root) {
            j--; // 找到第一个小于root的节点
        }

        // 如果前面还有大于root的节点，返回false
        for (int i = j - 1; i >= left; i--) {
            if (sequence[i] > root) {
                return false;
            }
        }

        // 再判定左子树和右子树
        return verify(sequence, left, j) && verify(sequence, j + 1, right - 1);
    }
}
