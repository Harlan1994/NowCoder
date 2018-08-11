package seclab.data_structure;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/7
 * Time: 16:07
 * Description: 平衡二叉树
 */
public class AVLTree {

    Node root;
    int size;
    int height;

    public AVLTree() {
        this.size = 0;
        this.height = 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 插入一个节点
     *
     * @param val
     */
    public void insert(int val) {

    }

    /**
     * 删除一个节点
     *
     * @param val
     * @return
     */
    public Node delete(int val) {
        return null;
    }

    /**
     * 是否已经存在某个节点
     *
     * @param val
     * @return
     */
    public boolean contains(Node root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        else {
            boolean left = contains(root.left, val);
            boolean right = contains(root.right, val);
            return left || right;
        }
    }

    /**
     * 遍历二叉树
     * <p>
     * mode 1 前序| 2 中序| 3 后续
     */
    public void traversal(int mode) {
        switch (mode) {
            case 1:
                preOrder(root);
                break;
            case 2:
                inOrder(root);
                break;
            case 3:
                postOrder(root);
                break;
            default:
                break;
        }
    }

    /**
     * right right 调整
     *
     * @param node
     */
    public void rr(Node node) {

    }

    /**
     * left left 调整
     */
    public Node ll(Node node) {
        Node p = node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return p;
    }

    /**
     * 左右调整
     *
     * @param node
     */
    public void lr(Node node) {

    }

    /**
     * 右左调整
     *
     * @param node
     */
    public void rl(Node node) {

    }

    /**
     * 前序遍历
     *
     * @return
     */
    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历
     *
     * @return
     */
    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 后续遍历
     *
     * @return
     */
    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }


    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
