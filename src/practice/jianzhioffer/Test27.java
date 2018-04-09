package practice.jianzhioffer;


/**
 * Created by wch on 2018/3/28.
 */

/**
 * 递归求解镜像树
 */
public class Test27 {
    static class BinaryTreeNode {
        double value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;

        BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 递归求解镜像树
     * @param root
     * @return
     */
    public static BinaryTreeNode mirrorTree(BinaryTreeNode root){
        if(root != null){
            BinaryTreeNode temp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(temp);
        }
        return root;
    }

    /**
     * 二叉树的前序遍历
     * @param root
     */
    public static void printTreeByOrder1(BinaryTreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        printTreeByOrder1(root.left);
        printTreeByOrder1(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode rootA = new BinaryTreeNode(8);
        BinaryTreeNode a1 = new BinaryTreeNode(8);
        rootA.left = a1;
        BinaryTreeNode a2 = new BinaryTreeNode(7);
        rootA.right = a2;
        BinaryTreeNode a3 = new BinaryTreeNode(9);
        a1.left = a3;
        BinaryTreeNode a4 = new BinaryTreeNode(2);
        a1.right = a4;
        BinaryTreeNode a5 = new BinaryTreeNode(4);
        a4.left = a5;
        BinaryTreeNode a6 = new BinaryTreeNode(7);
        a4.right = a6;
//        printTreeByOrder1(rootA);
        BinaryTreeNode root = mirrorTree(rootA);
        printTreeByOrder1(root);

    }}
