package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/3.
 */
public class Test49 {
    /**
     * 动态规划 & 空间换时间
     *
     * p是丑数，则2*p、3*p，5*p都是丑数，换句话说，每个丑数都是前面的丑数乘以2、3、5得来的
     * 问题的关键在于，排序和去重：比如1乘以2、3、5得到2、3、5，但是2乘以2为4，应该在5前面，而且2*3等于3*2
     * 解决办法：定义三个指针，分别代表*2，*3，*5的位置，即指针的行走速度是不同步的（但最终每个数，都会被三个指针路过，不会漏数）
     *          且3*2和2*3相等时，*2指针应移向它的下一位4，同时*3指针移向它的下一位3
     *
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution2(int index) {

        if(index < 1){
            return 0;
        }
        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        int t2 = 0,t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            uglyNum[i] = Math.min(uglyNum[t2]*2,Math.min(uglyNum[t3]*3,uglyNum[t5]*5));
            if(uglyNum[i] == uglyNum[t2]*2){
                t2++;
            }
            if(uglyNum[i] == uglyNum[t3]*3){
                t3++;
            }
            if(uglyNum[i] == uglyNum[t5]*5){
                t5++;
            }
        }
        return uglyNum[index-1];
    }

    /**
     * 暴力，过不了牛客的oj
     * 每个数都要判断，时间复杂度很高
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return 0;
        }
        int number = 1;
        int count = 1;
        while (count<index){
            number++;
            if(isUgly(number)){
                count++;
            }
        }
        return number;
    }

    private static boolean isUgly(int number) {
        if(number<1){
            return false;
        }
        while ((number & 1) == 0) {
            number = number >> 1;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        for (int index = 1; index < 15; index++) {
            System.out.print(GetUglyNumber_Solution(index)+" ");
        }

    }
}
