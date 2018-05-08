package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/8
 * Time: 09:50
 * Description:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * solution:其实就是树的遍历和递归的一种考察，当然，也可以用非递归，但是本质一样
 * <p>
 * 判定一棵树B是否是另一棵树A的子树，只需要遍历A,以A的任意一个节点作为根节点作为一颗子树C，判定C是否和B相同
 * 这个判断又是一个递归的判断
 */
public class B11170 {

    public static void main(String[] args) {

    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {

        // 两者其一为空则不可能是子树关系
        if (root1 == null || root2 == null) {
            return false;
        }

        boolean isRootTheSame = false;

        // 从根节点开始作为子树的根节点，和root2进行比较
        if (root1.val == root2.val) {
            isRootTheSame = isTheSame(root1, root2);
        }

        // 否则将所有的节点作为根节点和root2进行比较
        boolean isLeftTheSame = HasSubtree(root1.left, root2);
        boolean isRightTheSame = HasSubtree(root1.right, root2);

        return isRootTheSame || isLeftTheSame || isRightTheSame;
    }

    /**
     * 判定treeNode1是否和treeNode2上的节点完全匹配，treeNode2可以是treeNode1的一个子集，但是必须是从
     * 根节点开始一样，叶子节点或者分支节点多出来了没关系，也就是说只要treeNode2能够映射到treeNode1中的一部分就可以
     * 而且这一部分是从根节点开始的
     *
     * @param treeNode1
     * @param treeNode2
     * @return
     */
    public static boolean isTheSame(TreeNode treeNode1, TreeNode treeNode2) {

        // 如果是，那么treeNode2肯定先遍历完，也就是说递归出口肯定是treeNode2为空
        if (treeNode2 == null) {
            return true;
        }

        // 如果遍历到treeNode2不为空，而treeNode1已经空了，说明不匹配
        if (treeNode1 == null) {
            return false;
        }

        // 比较根节点是否相等
        if (treeNode1.val != treeNode2.val) {
            return false;
        }

        // 然后递归比较左右子树
        return isTheSame(treeNode1.left, treeNode2.left) && isTheSame(treeNode1.right, treeNode2.right);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
