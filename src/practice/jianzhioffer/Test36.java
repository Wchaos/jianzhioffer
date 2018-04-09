package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/30.
 */
public class Test36 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 使用递归
     * 定义链表尾节点，
     * 从先递归左子树，连接当前节点，再递归右子树
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert1(TreeNode pRootOfTree) {
        TreeNode lastlist = covertNode1(pRootOfTree,null);
        TreeNode pHead = lastlist;
        while (pHead != null && pHead.left != null) {
            pHead = pHead.left;
        }
        return pHead;
    }

    public TreeNode covertNode1(TreeNode root, TreeNode lastlist) {
        if (root == null)
            return null;
        TreeNode cur = root;
        if (cur.left != null) {
            lastlist = covertNode1(cur.left,lastlist);
        }
        cur.left = lastlist;
        if (lastlist != null) {
            lastlist.right = cur;
        }
        lastlist = cur;
        if (cur.right != null) {
            lastlist = covertNode1(cur.right,lastlist);
        }
        return lastlist;
    }

    /**
     * 使用递归
     * 定义链表头结点
     * 先递归右子树，连接当前节点，再递归右子树
     * @param root
     * @return
     */
    public TreeNode convert(TreeNode root) {

        if(root == null){
            return null;
        }
        TreeNode head = covertNode(root,null);
        return head;
    }
    public TreeNode covertNode(TreeNode root, TreeNode nextNodeInList){
        if(root == null){
            return nextNodeInList;
        }
        if(root.right != null){
            nextNodeInList = covertNode(root.right,nextNodeInList);

        }
        root.right = nextNodeInList;
        if(nextNodeInList != null) {
            nextNodeInList.left = root;
        }

        nextNodeInList = root;

        if(root.left != null){
            nextNodeInList = covertNode(root.left,nextNodeInList);
        }
        return nextNodeInList;

    }


}
