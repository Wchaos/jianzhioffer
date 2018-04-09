package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/25.
 */

import java.util.Scanner;

/**
 * 动态规划与贪心算法
 *
 * 割绳子，求各段乘积最大值
 */
public class Test14 {

    /**
     * 动态规划
     * 时间复杂度为O(N^2)
     * 空间复杂度为O(N), 新建了长度为N的数组
     * @param length
     * @return
     */
    public int maxProducAfterCutting1(int length){
        if(length<2){
            return 0;
        }else if(length == 2){
            return 1;
        }else if(length == 3){ //其实3也可以放到循环中去
            return 2;
        }
        int[] products = new int[length+1];
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;


        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i/2 ; j++) {
                int product = products[j]*products[i-j];
                if(max<product){
                    max = product;
                }
            }
            products[i] = max;
        }
        return  products[length];
    }

    /**
     * 贪心算法
     * 没有循环，时间复杂度为O(1)
     * 空间复杂度为O(1)
     * @param length
     * @return
     */
    public static int maxProducAfterCutting2(int length){
        if(length < 2){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        if(length == 3){
            return 2;
        }
        int max;
        int timesOf3 = length/3;
        if(length - 3*timesOf3== 1){
            timesOf3 -= 1;
        }
        int remainder = length - 3* timesOf3;
        max = (int)Math.pow(3,timesOf3)*remainder;
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int output = maxProducAfterCutting2(input);
        System.out.println(output);
    }
}
