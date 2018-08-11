package seclab.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/17
 * Time: 21:15
 * Description:
 */
public class B11213_把二叉树打印成多行 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(10);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(11);

        ArrayList<ArrayList<Integer>> arrayLists = Print(treeNode);

        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        int currentLevel = 1;
        int nextLevel = 0;
        if (pRoot != null) {
            queue.offer(pRoot);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll(); // 出队
                currentLevel--;
                level.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                    nextLevel++;
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                    nextLevel++;
                }

                if (currentLevel == 0) {
                    result.add(new ArrayList<>(level));
                    level.clear();
                    currentLevel = nextLevel;
                    nextLevel = 0;
                }
            }
        }
        return result;
    }
}
