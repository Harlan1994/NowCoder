package seclab.other;

public class BinaryTree {

    int sum;

    int data; // 根节点数据  
    BinaryTree left; // 左子树  
    BinaryTree right; // 右子树  

    public BinaryTree(int data, int sum) // 实例化二叉树类
    {
        this.data = data;
        this.sum = sum;
        left = null;
        right = null;
    }

    public static BinaryTree buildTree(int[] preOrder, int start, int end, int[] inOrder, int left, int right) { // 向二叉树中插入子节点

        if (start > end || left > right) {
            return null;
        }

        // 根节点
        int rootData = preOrder[start];
        BinaryTree binaryTree = new BinaryTree(rootData, rootData);

        // 找到中序遍历中根节点的位置
        int rootIndex = findIndexInArray(inOrder, rootData, left, right);

        // 根节点左边是左子树
        // 前序遍历序列的左子树 区间是 [start + 1, start + (rootIndex - left - 1 + 1)]
        // 需要计算出中序遍历中左子树的个数 rootIndex - 1 - left, 例如，10为根节点，前序遍历中， -2(start + 1), 到-4,有三个节点，即
        // 中序遍历左子树左右边界 [left, rootIndex - 1], 有 rootIndex - 1 - left + 1 = 3 - 1 - 0 + 1 = 3个节点
        // 10 -2 8 -4 6 7 5
        // 8 -2 -4 10 7 6 5
        BinaryTree leftNode = buildTree(preOrder, start + 1, start + rootIndex - left, inOrder, left, rootIndex - 1);

        // 右边是右子树
        BinaryTree rightNode = buildTree(preOrder, start + rootIndex - left + 1, end, inOrder, rootIndex + 1, right);

        binaryTree.left = leftNode;
        binaryTree.right = rightNode;

        return binaryTree;
    }

    public static int findIndexInArray(int[] array, int data, int left, int right) {
        int index = left;
        while (index <= right && array[index] != data) {
            index++;
        }
        return index;
    }
}