package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/7
 * Time: 14:57
 * Description:输入一棵二叉树，判断该二叉树是否是平衡二叉树
 */
public class B11192_平衡二叉树 {

    /**
     * 遍历每个节点，计算高度，如果发现左右两个子节点
     * 的高度相差大于1 => false
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        else {
            int left = length(root.left);
            int right = length(root.right);
            if (left - right > 1 || right - left > 1) {
                return false;
            }
            return true;
        }
    }

    public int length(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = length(root.left) + 1;
            int right = length(root.right) + 1;
            return left > right ? left : right;
        }
    }
}
