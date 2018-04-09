package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/4.
 */
public class Test55_1 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * new数组来保存每个子树的深度
     * @param root
     * @return
     */
    public boolean isBalanced_solution(TreeNode root) {
        int[] depth = new int[1];
        boolean result = isBalanced_solution(root,depth);
        System.out.println(depth[0]);
        return result;
    }

    private boolean isBalanced_solution(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] leftDepth = new int[1];
        int[] rightDepth = new int[1];
        boolean leftStatus = isBalanced_solution(root.left, leftDepth);
        boolean rightStatus = isBalanced_solution(root.right, rightDepth);
        depth[0] = 1 + (leftDepth[0] > rightDepth[0] ? leftDepth[0] : rightDepth[0]);
        if (leftStatus && rightStatus) {
            int diff = leftDepth[0] - rightDepth[0];
            if (diff <= 1 && diff >= -1) {
                return true;
            }
        }
        return false;
    }


    private boolean balance = true;

    /**
     * 最简单的思路，递归求深度的过程中，判断左右子树的深度差，如果深度差大于一，则将全局变量置为false;
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        TreeDepth(root);
        return balance;
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            this.balance = false;
        }
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        root.left = a1;
        root.right = a2;
        TreeNode a11 = new TreeNode(4);
        TreeNode a12 = new TreeNode(5);
//        a1.left = a11;
        a1.right = a12;
        TreeNode a121 = new TreeNode(7);
        a12.left = a121;
        TreeNode a22 = new TreeNode(6);
        a2.right = a22;

        Test55_1 test55_1 = new Test55_1();
        boolean res1= test55_1.isBalanced_solution(root);
//        boolean res2 = test55_1.isBalanced(root);
        System.out.println(res1);
//        System.out.println(res2);
    }
}
