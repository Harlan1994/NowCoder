package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/22
 * Time: 18:08
 * Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class B11179_二叉搜索树与双向链表 {

    public static void main(String[] args) {

        B11179_二叉搜索树与双向链表 b11179_二叉搜索树与双向链表 = new B11179_二叉搜索树与双向链表();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);
        TreeNode treeNode1 = b11179_二叉搜索树与双向链表.Convert(treeNode);
    }

    /**
     * 新建两个节点，分别表示当前链表的头节点，当前遍历的前驱节点
     */
    TreeNode pre = null;
    TreeNode head = null;

    /**
     * 中序遍历二叉树，根据中序遍历的顺序，为head节点按照顺序链接所有的节点
     * 并将head返回，pre节点用于记录当前节点的前驱节点
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertCore(pRootOfTree);
        return head;
    }

    public void ConvertCore(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }

        ConvertCore(pRootOfTree.left);

        if (head == null) { // 遍历到了最左边的节点
            head = pRootOfTree;
            pre = pRootOfTree;
        } else {
            pRootOfTree.left = pre; // 更新当前节点前驱
            pre.right = pRootOfTree; // 更新前驱节点后继
            pre = pRootOfTree; // 更新下一个节点的前驱节点
        }
        ConvertCore(pRootOfTree.right);
    }
}
