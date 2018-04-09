package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/26.
 */

/**
 * 输出从1到最大的n位整数
 * 推荐递归解法
 *
 * 书中使用char数组，每位占8bit
 * 而此处使用了int数组，每位占32bit,浪费了点内存
 */
public class Test17 {

    public void print1ToMaxDigits(int n) {
        if (n <= 0) {
            return;
        }
        int[] numbers = new int[n]; //n位负数是会报错，但是n=0时，不会报错，会导致程序进入死循环

        while (increment(numbers)) {
            printArrayAsNum(numbers);
        }
    }

    public boolean increment(int[] nums) {
        int carry = 1;
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (carry == 0) {
                break;
            }
            if (nums[i] + carry < 10) {
                nums[i] += carry;
                carry = 0;
            } else {
                if (i == nums.length - 1) {
                    return false;
                }
                nums[i] = 0;
            }
        }
        return true;
    }

    public void printArrayAsNum(int[] array) {
        boolean isBegining0 = true;
        for (int i = array.length - 1; i >= 0; i--) {
            if (isBegining0 && array[i] != 0) {
                isBegining0 = false;
            }
            if (!isBegining0) {
                System.out.print(array[i]);
            }
        }
        if(!isBegining0) {
            System.out.print("\t");
        }
    }

    /**
     * 递归解法
     * 先设置第一位，然后递归设置下一位，当最后移位设置好时，输出该数组表示的数
     *
     * @param n
     */
    public void print1ToMaxDigits2(int n) {
        if(n<=0){
            return;
        }
        int[] number = new int[n];
        geneticAndPrintNum(number,0);

    }
    public void geneticAndPrintNum(int[] arrays, int index){
        //当最后一位确定时，输出数组表示的数
        if(index==arrays.length){
            printArrayAsNum(arrays);
            return;
        }
        //按位递归
        for (int i = 0; i < 10; i++) {
            arrays[index] = i;
            geneticAndPrintNum(arrays,index+1);

        }

    }


    public static void main(String[] args) {
        Test17 test17 = new Test17();
        test17.print1ToMaxDigits2(2);
    }

}
