package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/4.
 */


/**
 * 在排序的数组中查找数字，统计其出现的次数
 */
public class Test53 {

    /**
     * 用两遍二分查找，找到数字出现的第一个索引和最后一个索引
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK_solution(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int firstIndex = getFirstIndexInArr(array,k,0,array.length-1);
        int lastIndex = getLastIndexInArr(array,k,0,array.length-1);
        if(firstIndex>-1&&lastIndex>-1){
            count = lastIndex-firstIndex+1;
        }
        return count;

    }
    private static int getFirstIndexInArr(int[] array, int target, int left, int right){
        if(left>right){
            return -1;
        }
        int mid = (left + right)/2;
        int index;
        if(target< array[mid]){
            index = getFirstIndexInArr(array,target,left,mid-1);
        }else if(target > array[mid]){
            index = getFirstIndexInArr(array,target,mid+1,right);
        }else{
            if((mid>0&&array[mid-1]!=target)|| mid == 0){
                index = mid;
            }else{
                index = getFirstIndexInArr(array,target,left,mid-1);
            }
        }
        return index;
    }
    private static int getLastIndexInArr(int[] array, int target, int left, int right){
        if(left>right){
            return -1;
        }
        int mid = (left + right)/2;
        int index;
        if(target< array[mid]){
            index = getLastIndexInArr(array,target,left,mid-1);
        }else if(target > array[mid]){
            index = getLastIndexInArr(array,target,mid+1,right);
        }else{
            if((mid<array.length-1&&array[mid+1]!=target)|| mid == array.length-1){
                index = mid;
            }else{
                index = getLastIndexInArr(array,target,mid+1,right);
            }
        }
        return index;
    }


    /**
     * 二分查找找到目标索引之后，从索引开始向左向右统计重复次数
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int index = getIndexInArr(array,k,0,array.length-1);
        if(index > -1) {
            int index2 = index + 1;
            while (index >= 0 && k == array[index]) {
                count++;
                index--;
            }
            while (index2 < array.length && k == array[index2]) {
                count++;
                index2++;
            }
        }
        return count;
    }
    private static int getIndexInArr(int[] array, int target,int left, int right){
        if(left > right){
            return -1;
        }
        int mid = (left+right)/2;
        int index;
        if(target <array[mid] ){
            index = getIndexInArr(array,target,left,mid-1); // mid==left时会出现，right指针比left指针小的情况
        }else if(target>array[mid]){
            index = getIndexInArr(array,target,mid+1, right);
        }else{
            index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5};
        int res = GetNumberOfK_solution(arr,3);
        System.out.println(res);
    }


}
