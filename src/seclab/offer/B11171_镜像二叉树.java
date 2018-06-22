package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/22
 * Time: 15:39
 * Description:
 */
public class B11171_镜像二叉树 {

    public static void main(String[] args) {

    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        // 交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        Mirror(root.left);
        Mirror(root.right);
    }
}
