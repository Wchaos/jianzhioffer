package practice.jianzhioffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wch on 2018/3/21.
 */


public class Test3 {
    /**
     * 利用计数排序类似的思想，时间复杂度O(n)
     * @param nums
     * @param repeatNum
     * @return
     */
    public static boolean findRepeatNum1(int[] nums, int[] repeatNum) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] >= nums.length) {
                return false;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int temp = nums[i];
                if (temp != nums[temp]) {
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                } else {
                    repeatNum[0] = temp;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用HashMap,空间换时间，时间复杂度O(n)
     * @param nums
     * @param repeatNum
     * @return
     */
    public static boolean findRepeatNum2(int[] nums, int[] repeatNum) {
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                repeatNum[0] = nums[i];
                return true;
            }else{
                map.put(nums[i],1);
            }
        }
        return false;
    }

    /**
     * 先排序在比较，排序时间复杂度为O(n) = nlogn
     * @param nums
     * @param repeatNum
     * @return
     */
    public static boolean findRepeatNum3(int[] nums, int[] repeatNum) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                repeatNum[0] = nums[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 利用字符串内置函数，时间复杂度O(n^2)
     * @param nums
     * @param repeatNum
     * @return
     */
    public static boolean findRepeatNum4(int[] nums, int[] repeatNum) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append((char)nums[i]);
        }
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            if(str.lastIndexOf(str.charAt(i)) != i){
                repeatNum[0] = nums[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 暴力遍历，时间复杂度O(n) = n^2
     * @param nums
     * @param repeatNum
     * @return
     */
    public static boolean findRepeatNum5(int[] nums, int[] repeatNum) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    repeatNum[0] = nums[i];
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int[] result1 = new int[2];
        int[] result2 = new int[2];
        int[] result3 = new int[2];
        int[] result4 = new int[2];
        int[] result5 = new int[2];
        boolean state1 = findRepeatNum1(nums,result1);
        boolean state2 = findRepeatNum2(nums,result2);
        boolean state3 = findRepeatNum3(nums,result3);
        boolean state4 = findRepeatNum4(nums,result4);
        boolean state5 = findRepeatNum4(nums,result5);
        System.out.println(state1);
        System.out.println(result1[0]);
        System.out.println(state2);
        System.out.println(result2[0]);
        System.out.println(state3);
        System.out.println(result3[0]);
        System.out.println(state4);
        System.out.println(result4[0]);
        System.out.println(state5);
        System.out.println(result5[0]);
    }


}
