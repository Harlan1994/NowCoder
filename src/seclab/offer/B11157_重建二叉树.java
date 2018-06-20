package seclab.offer;

public class B11157_重建二叉树 {

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
        int[] right_pre = new int[in.length - position - 1];
        int[] left_in = new int[position];
        int[] right_in = new int[in.length - position - 1];

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

    /**
     * 根据二叉树前序遍历和中序遍历序列，重构二叉树
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;
    }

    /**
     * 上面的方法是将步骤分开来了
     * 就是得到下一次递归的前序中序遍历的序列，然后再继续递归
     * 其实这可以直接原前序和中序序列中通过限定范围得到
     *
     * @param pre   整体的前序遍历序列
     * @param in    整体的中序序列
     * @param start 下一次递归前序序列开始位置
     * @param end   下一次递归前序序列结束位置
     * @param left  下一次递归中序序列开始位置
     * @param right 下一次递归中序序列结束位置
     * @return
     */
    public TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int start, int end, int left, int right) {
        // 递归需要出口,当前序序列或者中序序列的开始位置和大于结束位置，结束递归
        if (start > end || left > right) return null;

        // 新建节点,这是当前递归下的前序和中序下的根节点，即前序序列第一个节点
        TreeNode root = new TreeNode(pre[start]);

        // 接下来建立当前根节点的左右子树,需要先找到当中序序列中的根节点，才能分清楚左子树和右子树
        for (int i = left; i <= right; i++) {
            if (in[i] == pre[start]) { // 找到了根节点，那么这个位置左边的就是左子树，右边的就是右子树
                root.left = reConstructBinaryTreeCore(pre, in, start + 1, start + i - left, left, i - 1);
                root.right = reConstructBinaryTreeCore(pre, in, start + i - left + 1, end, i + 1, right);

                // 需要break
                break;
            }
        }
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
                root.left = createTree(root.left, tree, ++count);
                root.right = createTree(root.right, tree, ++count);
            }
        }
        return root;
    }

    static int[] pre;
    static int[] in;

    public static void main(String[] args) {
        String tree[] = {
                "1", "2", "4",
                "#", "#", "5", "8",
                "#", "#", "9", "#", "#",
                "3", "6", "#", "#", "7", "10", "#", "#", "#"
        };
        TreeNode root = null;
        B11157_重建二叉树 b11157重建二叉树 = new B11157_重建二叉树();
        root = b11157重建二叉树.createTree(root, tree, count);

        pre = new int[10];
        in = new int[10];

        b11157重建二叉树.preOrder(root);
        System.out.println();
        b11157重建二叉树.inOrder(root);
        System.out.println();

        TreeNode newTree = b11157重建二叉树.reConstructBinaryTree1(pre, in);
        k = 0;
        v = 0;
        b11157重建二叉树.preOrder(newTree);
        System.out.println();
        b11157重建二叉树.inOrder(newTree);
    }
}
