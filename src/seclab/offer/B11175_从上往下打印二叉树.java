package seclab.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/22
 * Time: 21:09
 * Description:层次遍历，比较简单
 */
public class B11175_从上往下打印二叉树 {

    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return result;
        queue.offer(root);
//        result.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            result.add(tmp.val);
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        return result;
    }
}
