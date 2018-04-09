package practice.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wch on 2018/3/29.
 */

/**
 * 从上到下不分层打印二叉树
 */
public class Test32 {

    static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 自己的解法，使用递归，没有书上解法效率高
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root != null){
            ArrayList<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            printFormTopToBottomCore(result,nodeList);
        }
        return result;
    }


    public void printFormTopToBottomCore(ArrayList<Integer> result,ArrayList<TreeNode> nodeList){
        if(nodeList == null || nodeList.size() == 0){
            return ;
        }
        ArrayList<TreeNode> childNodeList = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode curNode = nodeList.get(i);
            result.add(curNode.val);
            if(curNode.left !=null){
                childNodeList.add(curNode.left);
            }
            if(curNode.right != null){
                childNodeList.add(curNode.right);
            }
        }
        printFormTopToBottomCore(result,childNodeList);
    }

    /**
     *  剑指off上的解法（推荐）
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                result.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        return result;
    }


}
