package seclab.offer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/17
 * Time: 13:55
 * Description:
 */
public class B11177_二叉树中和为某一值的路径 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(10);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(11);
        FindPath(treeNode, 19);
    }

    static ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();

    /**
     * 深度优先搜索，搜索到叶子节点时结束并判断和是否为target
     *
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        int sum = 0;
        ArrayList<Integer> currentPath = new ArrayList<>();
        if(root == null)return allPaths;
        FindPathCore(root, target, sum, currentPath);
        return allPaths;
    }

    public static void FindPathCore(TreeNode root, int target, int sum, ArrayList<Integer> currentPath) {

        // 遍历到当前节点，加如sum，并放入当前路径中
        sum += root.val;
        Integer integer = new Integer(root.val);
        currentPath.add(integer);

        // 如果遍历到了叶子节点，判断该路径是否满足条件，满足条件则放入allPaths
        if (root.left == null && root.right == null) { // 到达叶子节点
            if (sum == target) {
                allPaths.add(new ArrayList<>(currentPath));
            }
        }

        // 否则继续递归遍历左右子树
        if (root.left != null) FindPathCore(root.left, target, sum, currentPath);
        if (root.right != null) FindPathCore(root.right, target, sum, currentPath);

        // 回溯的时候，当前路径要删除回退的节点
        currentPath.remove(integer);
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
