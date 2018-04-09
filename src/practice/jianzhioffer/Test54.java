package practice.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by wch on 2018/4/4.
 */

/**
 * 二叉搜索树第k大的节点
 */
public class Test54 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 使用递归中序遍历
     *
     * 此处直接获得中序遍历之后，查找第K大的节点
     * 书上，直接每次递归将k减一，可以在遍历过程中，获得第K大的节点，将至返回
     * @param pRoot
     * @param k
     * @return
     */
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        ArrayList<TreeNode> minOrder = new ArrayList<>();
        midOrderOfTree(pRoot, minOrder);
        TreeNode result = null;
        if (k > 0 && k <= minOrder.size()) {
            result = minOrder.get(k - 1);
        }
        return result;

    }

    public static void midOrderOfTree(TreeNode root, ArrayList<TreeNode> midOrder) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            midOrderOfTree(root.left, midOrder);
        }
        midOrder.add(root);
        if (root.right != null) {
            midOrderOfTree(root.right, midOrder);
        }
    }


}
