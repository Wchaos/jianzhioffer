package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/22.
 */
public class Test8 {
    static class TreeNode {
        int value;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent = null;

        TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 如果节点有右子节点，则从右子节点出发，找左叶子节点
     * 如果节点没有右子节点，则向父节点查找，如果当前节点在根节点的左子树，则返回根节点，否则返回null
     * @param treeNode
     * @return
     */
    public TreeNode findMidOrderNext(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.right != null) {
            treeNode = treeNode.right;
            while (treeNode.left != null) {
                treeNode = treeNode.left;
            }
            return treeNode;
        } else {
            while (treeNode.parent != null) {
                if (treeNode.parent.left == treeNode) {
                    return treeNode.parent;
                } else {
                    treeNode = treeNode.parent;
                }
            }
            return null;
        }
    }
}
