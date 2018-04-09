package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/21.
 */

/**
 * 长度为n+1的数组，元素值在1~n之间，寻找重复的元素
 * 1~n长度为n,所有数出现频次却为n+1,所以1~n内一定有元素重复
 * 可以对1~n用二分法划分为小片段，统计小片段的在数组内的频次
 */
public class Test3_1 {
    public int findRepeatNum(int[] nums, int[]repeatNum){

        int left = 1,right = nums.length-1;

        while(left <= right) {


            int mid = (right-left)/2+left;
            int count = countNums(nums, left, mid);
            if(left == right){
                if(count>1) {
                    return left;
                }else{
                    break;
                }
            }
            if (mid-left + 1 <count) {
                right = mid;

            }else{
                left = mid+1;
            }
        }
        return -1;

    }
    public int countNums(int[]nums,int left, int right){
        int count =0;
        for(int i = 0; i < nums.length; i++) {
           if(nums[i]>=left && nums[i]<= right){
               count++;
           }
        }
        return count;
    }
}
