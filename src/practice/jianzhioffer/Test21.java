package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/27.
 */
public class Test21 {
    public void reOrderOddEven1(int[] nums){
        if(nums == null|| nums.length == 0){
            return;
        }
        int left = 0,right = nums.length-1;
        while (left < right){
            while(left<right&&!isEven(nums[left])){
                left++;
            }
            while(left < right&&isEven(nums[right])){
                right--;
            }
            if(right > left) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }
    public boolean isEven(int num){

        return  (num&1)==0;
    }
}
