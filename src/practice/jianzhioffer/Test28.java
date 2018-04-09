package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/28.
 */

/**
 * 判断树是否是对称的
 */
public class Test28 {
    static class BinaryTreeNode {
        double value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;

        BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    public static boolean isSymmetrical(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right != null) {
            return isSymmetricalCore(root.left, root.right);
        }
        return false;
    }


    private static boolean equal(double num1, double num2) {
        return Math.abs(num1 - num2) < 0.0000001;
    }

    private static boolean isSymmetricalCore(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }else if(node1==null|| node2 ==null){
            return false;
        }else if(equal(node1.value, node2.value)){
            return false;
        }
        return isSymmetricalCore(node1.left, node2.right) && isSymmetricalCore(node1.right, node2.left);

    }

    public static void main(String[] args) {
        BinaryTreeNode rootA = new BinaryTreeNode(8);
        BinaryTreeNode a1 = new BinaryTreeNode(6);
        rootA.left = a1;
        BinaryTreeNode a2 = new BinaryTreeNode(6);
        rootA.right = a2;
        BinaryTreeNode a3 = new BinaryTreeNode(5);
        a1.left = a3;
        BinaryTreeNode a4 = new BinaryTreeNode(7);
        a1.right = a4;
        BinaryTreeNode a5 = new BinaryTreeNode(7);
        a2.left = a5;
        BinaryTreeNode a6 = new BinaryTreeNode(5);
        a2.right = a6;
        System.out.println(isSymmetrical(rootA));
    }
}
