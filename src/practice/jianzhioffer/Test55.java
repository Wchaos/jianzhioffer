package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/4.
 */


/**
 * 求二叉树的深度
 * 递归，当前节点深度为左子树深度和右子树深度中更大的那个加上一
 *
 *  拓展：判断一棵二叉树是不是平衡二叉树（任意节点左右子树深度相差不超过一）
 *  递归，当前节点是否平衡，取决于左右子树是否平衡
 */
public class Test55 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }



}
