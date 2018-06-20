package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/14
 * Time: 21:44
 * Description: 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * <p>
 * Solution：按照二叉搜索树的特点：根节点比左子树大比右子树小，并且满足递归定义，这样的情况下，中序遍历的结果就是从小到大的结果，输出的第k个就是我们要的结果
 */
public class B11215 {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(10);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(11);
        KthNode(treeNode, 3);
    }

    static int index = 0;

    static TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode result = inOrder(pRoot, k);
        System.out.println(result.val);
        return result;
    }

    /**
     * 按照中序遍历的顺序，需要在遍历根节点的的时候记录当前遍历的个数
     *
     * @param pRoot
     * @param k
     * @return
     */
    static TreeNode inOrder(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode resultLeft = inOrder(pRoot.left, k);
            if (resultLeft != null) return resultLeft;
            index++;
            if (index == k) {
                return pRoot;
            }
            TreeNode resultRight = inOrder(pRoot.right, k);
            if (resultRight != null) return resultRight;
        }
        return null;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
