package seclab.offer;

/**
 * User: Harlan1994
 * Date: 2017/9/2
 * Time: 10:17
 * Description:
 */
public class B11191 {

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthLeft = depth(root.left);
        int depthRight = depth(root.right);
        return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
    }

    public static void main(String[] args) {
        B11191 b = new B11191();
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(12);
        treeNode.right = new TreeNode(13);
        treeNode.left.left = new TreeNode(1010);
        treeNode.left.left.left = new TreeNode(1223);
        treeNode.left.left.right = new TreeNode(34);

        System.out.println(b.depth(treeNode));
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