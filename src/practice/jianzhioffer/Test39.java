package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/1.
 */

/**
 * 寻找数组中出现次数超过一半的数字
 * 法一：排序，输出中间位置的数字，时间复杂度为O(NlogN)
 * 法二：基于快速排序的思想，通过基准数的索引和中间位置索引的比较，判断维护基准数的哪一半边，时间复杂度O(N)
 * 法三：基于数组特点，每次减去两个不同的数，最后剩下的数就是，出现次数超过一半的数
 */
public class Test39 {

    public int MoreThanHalfNum(int [] array){
        if(array == null || array.length == 0){
            return 0; //牛客网上本题默认返回0代表输入非法
        }
        int result = array[0]; //取第一个数为第一个基准数
        int count = 1; //记录基准数出现次数
        for (int i = 1; i < array.length; i++) {
            if(count == 0){    //基准数次数为0时，取当前数为基准数
                result = array[i];
                count = 1;
            }else if(array[i] == result){  //后续的数等于基准数，基准数次数加一
                count++;
            }else{            //后续的数不等于基准数，消去一个基准数，基准数次数减一
                count--;
            }
        }
        if(!isMoreThanHalf(array,result)){
            result = 0;
        }
        return result;

    }


    /**
     * 基于快排思想查找数组中任意第K大的元素
     * @param array
     * @return
     * @throws Exception
     */
    public int MoreThanHalfNum_Solution(int [] array) throws Exception{

        if(array == null || array.length == 0){
            throw new Exception("数组为null或者数组为空");
        }
        int middle = array.length>>1;
        int left = 0;
        int right = array.length -1;
        int baseIndex = partition(array,left,right);
        while(baseIndex != middle) {
            if (baseIndex > middle) {
                right = baseIndex-1;
                baseIndex = partition(array,left,right);
            }else{
                left = baseIndex+1;
                baseIndex = partition(array,left,right);
            }
        }
        int result = array[middle];
        if(!isMoreThanHalf(array,result)){
            throw new Exception("输入数组没有出现次数超过一半的数字");
        }
        return result;

    }

    private int partition(int[] array, int left, int right){
        int base = array[left];
        while (left < right){
            while (left < right && array[right] >= base){
                right--;
            }
            array[left] = array[right];
            while(left<right&&array[left]<=base){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = base;
        return left;
    }

    private boolean isMoreThanHalf(int[] array, int number){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == number){
                count++;
            }
        }
        boolean flag = true;
        if(count*2 <= array.length ){
            flag = false;
        }
        return flag;
    }
}
