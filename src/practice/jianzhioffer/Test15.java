package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/25.
 */

/**
 * 位运算
 *
 * 输入一个数，输出其二进制表示中1的个数
 */
public class Test15 {
    /**
     * 一个二进制数n,将其减一，会将其最右边的1变为0，如果这个1右边还有0，则这些0会变为1，而该1左边不受影响
     * (n-1)&n，该位与运算之后，相当于仅将原数最右边的1变为了0。
     * @param n
     * @return
     */
    public static int numberof1_bestSolution(int n){
        int count = 0;
        while(n!=0){
            ++count;
            n=(n-1)&n;
        }
        return count;
    }

    /**
     * 常规解法
     * 将1左移位，分别和n的各位做为与运算
     * @param n
     * @return
     */
    public static int numberof1(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n&flag) != 0){
                System.out.println("in here");
                count++;
            }
            flag = flag<<1;
        }
        return count;
    }

    //对原数移位，当数位负数时，会出现死循环
    //负数用补码表示(补码等于反码加一
    //负数做右移位操作时，最左边填充的是符号位1
    public static int NumberOf1(int n){
        int count = 0;
        while(n != 0){
            if((n&1)!=0){
                System.out.println("in here");
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        int count = numberof1(-9);
        System.out.println(count);

    }




}
