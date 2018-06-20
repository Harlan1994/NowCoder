package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/16
 * Time: 10:38
 * Description:
 */
public class B11210_二叉树的下一个节点 {

    public static void main(String[] args) {
        TreeLinkNode head = new TreeLinkNode(1);
        head.next = null;
        head.left = new TreeLinkNode(2);
        head.right = new TreeLinkNode(3);

        head.left.next = head;
        head.left.left = new TreeLinkNode(4);
        head.left.right = new TreeLinkNode(5);

        head.right.next = head;
        head.right.left = new TreeLinkNode(6);
        head.right.right = new TreeLinkNode(7);

        GetNext(head.left);
    }

    /**
     * 解决这一题需要对二叉树的遍历的一些特点有一定的了解
     * 中序遍历中，遍历的过程是一个递归的过程，先遍历左孩子，再遍历根节点，最后遍历右孩子
     * 并且这是一个递归的过程，也就是左子树一定全部在根节点之前遍历，右孩子则全部在根节点之后。
     * 要求当前节点在中序遍历中的下一个节点：
     * 1. 当前节点看成是一个子树的根节点（其实每次递归遍历都是这么看的）
     * 2. 那么如果根节点遍历完了，下一个需要遍历的就是右子树了
     * 3. 右子树又是一个递归的过程，所以只需要根据中序遍历，找到右子树中第一个需要遍历的就是当前节点的下一个中序遍历节点。
     * 4. 但是右子树可能为空，所以此时，就等于说以当前节点为根节点的子树已经遍历完了，那么此时就有三种情况：
     * (1) 当前节点是某一个节点的左子树，此时中序遍历的下一个节点就是当前节点的父节点
     * (2) 当前节点是某一个节点的右子树，此时中序遍历的下一个节点就有点复杂了。看tips。
     * (3) 当前节点是整棵树的根节点，也就是没有下一个节点，返回空
     *
     * tips: 如果当前节点是某一个节点的右子树，说明以当前节点父节点作为根节点的子树依旧是遍历完了的，这样回溯下去，直到找到一个节点，这个节点
     * 是它父节点的左子树，这样才说明还有一个右节点没有遍历完，当然，根节点也没有遍历完，此时中序遍历的下一个节点就是该节点的父节点了。
     *
     * @param pNode
     * @return
     */
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }

        // 中序找下一个节点，右子树不为空那肯定是找右子树中最左边的那颗
        if (pNode.right != null) {
            TreeLinkNode rightLastLeft = pNode.right;
            while (rightLastLeft.left != null) {
                rightLastLeft = rightLastLeft.left;
            }
            return rightLastLeft;
        }

        // 右子树是空的，那么往上回溯，知道回溯到某一个根节点的左子树不为就是它为止
        TreeLinkNode temp = pNode;
        while (temp.next != null) {
            if (temp.next.left == temp) {
                return temp.next;
            }
            temp = temp.next;
        }

        return null;
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
