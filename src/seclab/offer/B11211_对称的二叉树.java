package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/17
 * Time: 21:43
 * Description:请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class B11211_对称的二叉树 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        else {
            return compare(pRoot.left, pRoot.right);
        }
    }

    boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2 == null; // 比较两个节点是否都为空
        if (node2 == null) return false; // 若到了这里，肯定不想等，即不对称
        if (node1.val != node2.val) { // 不想等，也不对成
            return false;
        }
        // 相等的化，比较左子树的右子树和右子树的左子树是否相等
        // 以及左子树的左子树和右子树的右子树
        return compare(node1.left, node2.right) && compare(node1.right, node2.left);
    }
}
