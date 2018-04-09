package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/2.
 */
public class Test42 {

    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if(sum < 0 ){
                sum = 0;
            }
            sum+= array[i];
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
