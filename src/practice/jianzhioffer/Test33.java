package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/29.
 */

import java.util.Arrays;

/**
 * 二叉搜索树的后序遍历
 */
public class Test33 {

    static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        /**
         * 找到分界点，递归判断
         * @param nums
         * @return
         */
        public static boolean verifySquenceOfBST(int[] nums){
            if(nums == null || nums.length ==0){
                return false;
            }
            int length = nums.length;

            int root = nums[length-1];
            int leftRoot = -1;  //默认全为右子树
            for (int i = length-2; i >= 0 ; i--) {
                if(nums[i] < root){
                    leftRoot = i;  //找到左子树的根节点
                    break;
                }
            }
            for (int i = 0; i <= leftRoot; i++) {
                if(nums[i] > root){   //判断左子树是否都小于根节点
                    return false;
                }
            }
            boolean result = true;
            if(leftRoot>=0){
                int[] leftTree = Arrays.copyOfRange(nums,0,leftRoot+1);
                result &= verifySquenceOfBST(leftTree);
            }
            if(leftRoot+1<length-1){
                int[] rightTree = Arrays.copyOfRange(nums,leftRoot+1,length-1);
                result &= verifySquenceOfBST(rightTree);
            }
            return result;
        }
    }





}
