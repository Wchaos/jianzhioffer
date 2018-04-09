package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/23.
 */
public class Test11 {
    /**
     * 部分排序的数组，使用二分查找的情况
     * @param nums
     * @return
     */
    public int findMinNum(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("nums is null");
        }
        int minIndex = 0;
        if (nums.length > 1) {
            int left = 0;
            int right = nums.length - 1;
            while (nums[left] >= nums[right]) {
                if (right - left == 1) {
                    minIndex = right;
                    break;
                }
                int mid = (right + left) / 2;
                if(nums[left]==nums[right]&&nums[mid] == nums[left]){
                    return minInOrder(nums,left,right); //特殊情况只能使用顺序查找
                }
                if (nums[mid] >= nums[left]) {
                    left = mid;
                }
                if (nums[mid] <= nums[right]) {
                    right = mid;
                }
            }
        }
        return nums[minIndex];
    }
    private int minInOrder(int[] nums, int left, int right){
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 4, 5, 1, 2};
        int[] nums = {1,0,1,1,1,1,1};
        Test11 test11 = new Test11();
        int min = test11.findMinNum(nums);
        System.out.println(min);
    }

}
