package practice.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wch on 2018/3/31.
 */

/**
 * 序列化二叉树和反序列化二叉树
 */
public class Test37 {

    static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeCore(root,sb);
        return sb.toString();
    }

    public void serializeCore(TreeNode root,StringBuffer sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serializeCore(root.left,sb);
        serializeCore(root.right,sb);
    }

    public TreeNode deserialize(String str) {

        Queue<String> queue = new LinkedList<>();
        String[] strArr = str.split(",");
        for (int i = 0; i < strArr.length; i++) {
            queue.add(strArr[i]);
        }
        TreeNode root = deserialize(queue);
        return root;
    }

    /**
     * 此处使用queue来确保递归过程中，处理的字符在变化
     * 也可以使用一个全局变量来记录str当前处理字符的index
     * @param queue
     * @return
     */
    public TreeNode deserialize(Queue<String> queue){
        if(queue == null || queue.isEmpty()){
            return null;
        }
        String str = queue.poll();
        if(str.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(str));
        treeNode.left = deserialize(queue);
        treeNode.right = deserialize(queue);
        return treeNode;
    }

}
