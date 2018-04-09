package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/21.
 */
public class Test4 {

    /**
     * 从二维矩阵右上顶点开始遍历，比较巧妙，推荐
     * @param nums
     * @param rows
     * @param cols
     * @param target
     * @return
     */
    public static boolean findElement2(int[][] nums,int rows, int cols, int target){
        boolean found = false;

        if(nums != null && rows > 0&&cols >0){
            int i = 0;
            int j = cols-1;
            while(i<rows && j>=0){
                if(nums[i][j] == target){
                    found = true;
                    break;
                }else if(nums[i][j]>target){
                    j--;
                }else {
                    i++;
                }
            }
        }
        return found;
    }

    /**
     * 二分法
     * 通过递归调用每次减少1/4的查找范围
     * @param target
     * @param array
     * @return
     */
    boolean Find(int target, int[][] array) {
        if(array == null){
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        return find(target, array, 0, rows-1,0,cols-1);
    }


    public static boolean find(int target, int[][] array, int rowStart, int rowEnd, int colStart, int colEnd){
        if(rowStart>rowEnd || colStart>colEnd){  //越界直接返回false,反正后面是"或"的关系，只要在不越界部分找到就行
            return false;
        }
        if(rowStart == rowEnd&&colStart == colEnd){
            return target == array[rowStart][colStart];
        }
        boolean result ;
        int rowMid = (rowStart+rowEnd)/2;
        int colMid = (colStart+colEnd)/2;
        if(target>array[rowMid][colMid]){
            result = find(target,array,rowStart,rowMid,colMid+1,colEnd)||find(target,array,rowMid+1,rowEnd,colStart,colEnd);
        }else if(target < array[rowMid][colMid]){
            result = find(target,array,rowStart,rowEnd,colStart,colMid-1)||find(target,array,rowStart,rowMid-1,colMid,colEnd);
        }else {
            result = true;
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean result2 = findElement2(nums,4,4,10);
        System.out.println(result2);

    }
}
