package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/3.
 */

/**
 * 数组中逆序对的个数
 */
public class Test51 {
    /**
     * 归并排序，和书上思路一样，但是会改变原数组
     * 而且每次递归都会new数组，空间复杂度为O（NlogN）,书上解法，只创建了一个数组，空间复杂度为O(N)
     * @param array
     * @return
     */
    public static int InversePairs_solution(int [] array) {
        if(array == null|| array.length == 0){
            return 0;
        }
        int count = inversePairsCore(array,0,array.length-1);
        return count;

    }
    private static int inversePairsCore(int[] array, int start, int end){
        if(start == end){
            return 0;
        }
        int mid = (start+end)/2;
        int leftCount = inversePairsCore(array,start,mid);
        int rightCount = inversePairsCore(array,mid+1,end);
        int[] copy = new int[array.length];
        int i = mid;
        int j = end;
        int indexOfCopy = end;
        int count = 0;
        while(i>=start&&j>mid){
            if(array[i]>array[j]){
                copy[indexOfCopy] = array[i];
                indexOfCopy--;
                i--;
                count += j-mid;
            }else{
                copy[indexOfCopy] = array[j];
                indexOfCopy--;
                j--;
            }
        }
        while(i>=start){
            copy[indexOfCopy] = array[i];
            indexOfCopy--;
            i--;
        }
        while (j>mid){
            copy[indexOfCopy] = array[j];
            indexOfCopy--;
            j--;
        }
        for (int k = start; k <= end; k++) {
            array[k] = copy[k];
        }
        return leftCount+rightCount+count;
    }


    /**
     * 书上解法，归并排序，不改变原数组（递归调用比较的过程比较难理解）
     * @param array
     * @return
     */
    public static int InversePairs(int [] array) {
        if(array == null|| array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i]= array[i];
        }
        int count = inversePairsCore(array,copy,0,array.length-1);
        return count;

    }
    private static int inversePairsCore(int[] array, int[] copy, int start, int end){
        if(start == end){
            copy[start] = array[start];
            return 0;
        }
        int mid = (start+end)/2;
        int leftCount = inversePairsCore(copy,array,start,mid);
        int rightCount = inversePairsCore(copy,array,mid+1,end);
        int i = mid;
        int j = end;
        int indexOfCopy = end;
        int count = 0;
        while(i>=start&&j>mid){
            if(array[i]>array[j]){
                copy[indexOfCopy] = array[i];
                indexOfCopy--;
                i--;
                count += j-mid;
                if(count>=1000000007) {
                    count%=1000000007;
                }
            }else{
                copy[indexOfCopy] = array[j];
                indexOfCopy--;
                j--;
            }
        }
        while(i>=start){
            copy[indexOfCopy] = array[i];
            indexOfCopy--;
            i--;
        }
        while (j>mid){
            copy[indexOfCopy] = array[j];
            indexOfCopy--;
            j--;
        }
        return leftCount+rightCount+count;
    }


    /**
     * 暴力，过不了牛客网oj
     * @param array
     * @return
     */
    public static int inversePairs(int [] array) {

        if(array== null||array.length < 2){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]>array[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 7,5,6,4};
        int res = InversePairs_solution(arr);
        System.out.println(res);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }







}
