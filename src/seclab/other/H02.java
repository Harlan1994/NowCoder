package seclab.other;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/25
 * Time: 20:02
 * Description:
 */
public class H02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] preOrderStr = scanner.nextLine().split(" ");
        String[] inOrderStr = scanner.nextLine().split(" ");

        int[] midOrder = new int[inOrderStr.length];
        int[] preOrder = new int[preOrderStr.length];

        for (int i = 0; i < midOrder.length; i++) {
            midOrder[i] = Integer.parseInt(inOrderStr[i]);
            preOrder[i] = Integer.parseInt(preOrderStr[i]);
        }

        BinaryTree root = BinaryTree.buildTree(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
        compute(root);
        inOrder(root);
    }

    public static void compute(BinaryTree root) {
        if (root == null) {
            return;
        } else {
            compute(root.left);
            compute(root.right);
            int left = root.left == null ? 0 : root.left.data + root.left.sum;
            int right = root.right == null ? 0 : root.right.data + root.right.sum;
            root.sum = left + right;
        }
    }

    public static void inOrder(BinaryTree binaryTree){
        if(binaryTree != null){
            inOrder(binaryTree.left);
            System.out.print(binaryTree.sum + " ");
            inOrder(binaryTree.right);
        }
    }
}
