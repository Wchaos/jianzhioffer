package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/4.
 */

/**
 * 找出数组中只出现一次的两个数字，其余数字都出现了两次
 * 思路：如果数组中只有一个数字出现一次，其余都出现了两次，那问题会很简单，直接异或就能得到结果
 * 想办法数组分成上述的情况：
 * 利用两个不同数字的某一比特位不相同，从而将数组分成两半，保证两个不同数字分在不同组，而相同的数字不会分开
 */
public class Test56 {

    public static int[] findNumsAppearOnce(int[] data) {
        int[] twoDifferentNums = new int[]{0, 0};
        int resultExclusiveOR = 0;
        for (int i = 0; i < data.length; i++) {
            resultExclusiveOR ^= data[i];
        }
        int separator = findFirstBitIsOne(resultExclusiveOR);

        for (int i = 0; i < data.length; i++) {
            if ((data[i] & separator) == 0) {
                twoDifferentNums[0] ^= data[i];
            } else {
                twoDifferentNums[1] ^= data[i];
            }
        }
        return twoDifferentNums;
    }

    private static int findFirstBitIsOne(int num) {
        if(num == 0){
            return 0;
        }
        int result = 1 << 31;    //第32位为符号位,如果只处理正数情况，只左移30位就可以了
        while (result >= Integer.MIN_VALUE) {
            if ((num & result) != 0) {
                break;
            } else if (result == Integer.MIN_VALUE) {
                result = 1 << 30;
            } else {
                result = result >> 1;  //注意负数直接右移会出问题，所以需要上一个if条件转为正数
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{-2, -4, 3, 6, 3, -2, 5, 5};
        int[] result = findNumsAppearOnce(data); // -4,6
        System.out.println(result[0]);
        System.out.println(result[1]);

    }


}
