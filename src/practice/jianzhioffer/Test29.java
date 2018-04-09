package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/28.
 */
public class Test29 {

    public static void printMatrixInCircle(int[][] nums) {
        if (nums == null || nums.length == 0 ) {
            return;
        }
        //判断二维数组是否是矩阵
        for (int i = 0;i<nums.length;i++){
            if(nums[i].length != nums.length){
                return;
            }
        }
        printMatrixInCircle(nums, 0);

    }

    public static void printMatrixInCircle(int[][] nums, int beginIndex) {
        int endIndex = nums.length - beginIndex-1;
        if (beginIndex > endIndex) {
            return;
        }

        for (int j = beginIndex; j <= endIndex; j++) {
            System.out.print(nums[beginIndex][j] + "  ");
        }

        for (int i = beginIndex + 1 ; i <= endIndex; i++) {
            System.out.print(nums[i][endIndex] + "  ");
        }

        for (int j = endIndex-1 ; j >= beginIndex; j--) {
            System.out.print(nums[endIndex][j] + "  ");
        }

        for (int i = endIndex-1; i > beginIndex; i--) {
            System.out.print(nums[i][beginIndex] + "  ");
        }
        printMatrixInCircle(nums, beginIndex + 1);


    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrixInCircle(nums);
    }


}
