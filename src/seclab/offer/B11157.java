package seclab.offer;

import java.util.Scanner;

public class B11157 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 根据二叉树前序遍历和中序遍历序列，重构二叉树
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int position = 0;
        if (pre.length <= 0 || in.length <= 0) {
            return null;
        }

        // 前序遍历第一个节点是二叉树的根节点
        TreeNode root = new TreeNode(pre[0]);

        // 找到根节点在中序遍历序列的位置
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                position = i;
                break;
            }
        }

        // 确定需要继续递归下去的左子树和右子树的先序和中序序列
        int[] left_pre = new int[position];
        int[] right_pre = new int[in.length - position];
        int[] left_in = new int[position];
        int[] right_in = new int[in.length - position];

        // 前序序列中的左子树和中序序列中的左子树
        int j = 0;
        int k = 0;
        for (int i = 1; i < position + 1; i++) {
            left_pre[j++] = pre[i];
            left_in[k++] = in[i - 1];
        }

        // 前序序列中的左子树和中序序列中的右子树
        j = 0;
        k = 0;
        for (int i = position + 1; i < in.length; i++) {
            right_pre[j++] = pre[i];
            right_in[k++] = in[i];
        }

        // 确定完了下一次需要递归的左子树和右子树就可以开始递归了
        root.left = reConstructBinaryTree(left_pre, left_in);
        root.right = reConstructBinaryTree(right_pre, right_in);

        return root;
    }

    static int v = 0;

    /**
     * 先序遍历
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        pre[v++] = root.val;
        preOrder(root.left);
        preOrder(root.right);
    }

    static int k = 0;

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        in[k++] = root.val;
        inOrder(root.right);
    }

    static int count = 0;

    /**
     * tree序列是按照以下规则建立的二叉树序列：
     * 序列顺序是先序遍历
     * 空节点用 “#” 代替，说明这个节点是空的
     *
     * @return
     */
    public TreeNode createTree(TreeNode root, String tree[], int pos) {

        if (pos < tree.length) {
            if (tree[pos].equals("#")) return null;
            else {
                root = new TreeNode(Integer.parseInt(tree[pos]));
                TreeNode left = null;
                TreeNode right = null;
                root.left = createTree(left, tree, ++count);
                root.right = createTree(right, tree, ++count);
            }
        }
        return root;
    }

    static int[] pre;
    static int[] in;

    public static void main(String[] args) {
        String tree[] = {
                "1",
                "2", "4",
                "#", "#", "#", "#",
                "8", "13", "#", "5", "9", "14", "#", "10",
                "#", "15", "3", "6", "11", "#", "#", "#", "#", "#", "7", "12", "14", "#", "#", "#"
        };
        TreeNode root = null;
        B11157 b11157 = new B11157();
        root = b11157.createTree(root, tree, count);

        pre = new int[16];
        in = new int[16];

        b11157.preOrder(root);
        System.out.println();
        b11157.inOrder(root);
        System.out.println();

        for (int i = 0; i < 16; i++) {
            System.out.print(pre[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < 16; i++) {
            System.out.print(in[i] + " ");
        }
        System.out.println();

        TreeNode newTree = b11157.reConstructBinaryTree(pre, in);
        b11157.preOrder(newTree);
        System.out.println();
        b11157.inOrder(newTree);
    }
}
