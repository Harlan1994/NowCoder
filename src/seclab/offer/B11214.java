package seclab.offer;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/5
 * Time: 17:34
 * Description:请实现两个函数，分别用来序列化和反序列化二叉树
 * 思路：序列化：其实就是用String保存一颗二叉树
 * 反序列化：从String中生成原来的二叉树
 */
public class B11214 {

    static int index = -1;


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(12);
        treeNode.right = new TreeNode(13);
        treeNode.left.left = new TreeNode(1010);
        treeNode.left.left.left = new TreeNode(1223);
        treeNode.left.left.right = new TreeNode(34);

        preOrder(treeNode);
        System.out.println("\n.............");

        String seria = Serialize(treeNode);
        System.out.println(seria);
        TreeNode deSeria = Deserialize(seria);

        System.out.println(".............");
        preOrder(deSeria);
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 用先序遍历，空节点用#代替
     *
     * @param root
     * @return
     */
    static String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) { // 递归出口，节点为空时回溯
            sb.append("#,");
            return sb.toString();
        }

        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));

        return sb.toString();
    }

    static TreeNode Deserialize(String str) {
        index++; // 下一个字符
        TreeNode node = null;
        if (index >= str.length()) return null;

        String[] splits = str.split(",");

        if (!(splits[index].equals("#"))) {
            node = new TreeNode(Integer.valueOf(splits[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
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
