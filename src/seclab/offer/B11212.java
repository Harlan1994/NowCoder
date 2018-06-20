package seclab.offer;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/10
 * Time: 17:03
 * Description:
 */
public class B11212 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(10);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(11);

        ArrayList<ArrayList<Integer>> allNums = Print(treeNode);

    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        // 先将root节点放入栈中
        ArrayList<ArrayList<Integer>> allNums = new ArrayList<>();

        if(pRoot == null)return allNums;

        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();

        oddStack.push(pRoot);

        boolean isOddLevel = true;

        // 如果不是两者都是空的，也就是说两者不能同时都是空的，必须有一个是非空的
        // 其实奇数层和偶数层总有一个是空的，是循环交替的一个过程
        // 只有在最后都完成遍历的情况下才会都是空的
        while (!(oddStack.isEmpty() && evenStack.isEmpty())) {

            ArrayList<Integer> curLevel = new ArrayList<>();

            if (isOddLevel) {

                while (!oddStack.isEmpty()) {
                    TreeNode cur = oddStack.pop();
                    curLevel.add(cur.val);

                    if (cur.left != null) {
                        evenStack.push(cur.left);
                    }

                    if (cur.right != null) {
                        evenStack.push(cur.right);
                    }
                }
                allNums.add(curLevel);
                isOddLevel = false;
            } else {
                while (!evenStack.isEmpty()) {
                    TreeNode curEven = evenStack.pop();
                    curLevel.add(curEven.val);

                    if (curEven.right != null) {
                        oddStack.push(curEven.right);
                    }

                    if (curEven.left != null) {
                        oddStack.push(curEven.left);
                    }
                }

                allNums.add(curLevel);
                isOddLevel = true;
            }
        }
        return allNums;
    }

    // 分层遍历，确定上下层
    public ArrayList<ArrayList<Integer> > levelOrder(TreeNode pRoot) {
        if (pRoot == null) return null;

        int curLevelCount = 1; // 当前层的节点个数,初始化时为1（root节点只有一个）
        int nextLevelCount = 0; // 下一层的节点个数，初始时不是知道，设为0

        // 先将root节点放入栈中
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(pRoot);
        TreeNode cur = pRoot;

        ArrayList<Integer> curLevel = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allNums = new ArrayList<>();

        while (!queue.isEmpty()) {
            cur = queue.poll();
            curLevel.add(cur.val);
            curLevelCount--;

            if(cur.left != null){
                queue.addFirst(cur.left);
                nextLevelCount++;
            }

            if(cur.right != null){
                queue.addFirst(cur.right);
                nextLevelCount++;
            }

            if(0 == curLevelCount){
                allNums.add(curLevel);
                curLevel = new ArrayList<>(); // 清空
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return allNums;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
