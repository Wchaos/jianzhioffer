package practice.jianzhioffer;

import java.util.Arrays;

/**
 * Created by wch on 2018/3/22.
 */
public class Test7 {
    static class TreeNode{
        int value;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int value){
            this.value = value;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] mid){
        if(pre == null || mid == null){
            return null;
        }
        if(pre.length == 0|| mid.length == 0){
            return null;
        }
        if(pre.length != mid.length){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i <mid.length ; i++) {
            if(mid[i]==pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(mid,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(mid,i+1,mid.length));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] mid = {4,7,2,1,5,3,8,6};

        Test7 test7 = new Test7();
        TreeNode root =  test7.reConstructBinaryTree(pre,mid);
        System.out.println(root.left.value);
    }
}
