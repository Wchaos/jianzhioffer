package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/5.
 */

/**
 * 找到数组中唯一只出现一次的数字（其他数字都出现3次）
 */
public class Test56_1 {

    public static int findNumAppearOnce(int[] data) {
        if (data == null) {
            return 0;
        }
        int[] bitSum = new int[32];  //索引为大的为高位
        for (int i = 0; i < data.length; i++) {
            for (int j = 31; j >= 0; j--) {
                int index = 1 << j;
                if ((data[i] & index) != 0) {
                    bitSum[j]++;
                }
            }
        }
        int result = turnBinaryArrToNum(bitSum);
        return result;
    }

    /**
     * 处理得到的位数组
     * 注意处理负数
     * @param binaryArr
     * @return
     */
    private static int turnBinaryArrToNum(int[] binaryArr){
        for (int i = 31; i >= 0 ; i--) {
            binaryArr[i] = binaryArr[i]%3;
        }
        if(binaryArr[31] == 1){
            for (int i = 30; i >= 0 ; i--) {
                binaryArr[i] = binaryArr[i]^1;
            }
        }
        int result = 0;
        for (int i = 30; i >= 0 ; i--) {
            if(binaryArr[i] == 1){
                result += 1<<i;
            }
        }
        if(binaryArr[31] == 1){
            result = -(result+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 1, 1, 2, 2, 2, -4, 3, 3, 3, 5, 5, 5};
        int result = findNumAppearOnce(data);
        System.out.println("result = " + result);


    }
}
