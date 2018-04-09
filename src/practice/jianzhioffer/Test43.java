package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/2.
 */

/**
 * 输入数n,统计1~n个整数的十进制表示中,'1'出现的次数。
 */
public class Test43 {
    /**
     * 从低位向高位遍历，计算每一位为1时，有多少种可能，将各位为1的总可能数累加即为1出现的个数。
     *
     * 以数abcde为例：计算c=1时,c将数分为前缀ab和后缀de
     * c>1: 00~ab共有（ab+1）个100~199种可能;
     * c=1: 00~(ab-1)共有ab个100~199种可能,和ab100~ab1de共de+1种可能
     * c=0: 00~(ab-1)共有ab个100~199种可能
     *
     * @param num
     * @return
     */
    public int NumberOf1Between1AndN(int num) {

        int count = 0;
        int pre ;
        int back;
        for (int weight = 1; weight <= num; weight *= 10) {
            pre = num / weight;
            back = num % weight;
            count += (pre+8)/10*weight;
            if(pre%10 == 1){
                count += back+1;
            }
        }
        return count;
    }


    /**
     * 数abcde拆分为1~bcde和（bcde+1）~abcde两组数
     * 处理后一组：a='0'时,数abcde就是bcde
     * a='1'时,(bcde+1)+(length-1)*pow(10,length-2);其中length-1代表后4位选一位为1
     * a>'1'时，a=1共有pow(10,length-1)个数，所以总数为pow(10,length-1)+a*(length-1)*pow(10,length-2)
     * <p>
     * 递归处理前一组
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {

        String str = String.valueOf(n);
        int result = numberOf1Between1AndN(str);
        return result;

    }

    private int numberOf1Between1AndN(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;
        int length = str.length();
        if (length == 1) {
            if (str.charAt(0) >= '1') {
                return 1;
            } else {
                return 0;
            }
        } else if (str.charAt(0) == '0') {
            String sub = str.substring(1);
            count += numberOf1Between1AndN(sub);
        } else if (str.charAt(0) == '1') {
            String sub = str.substring(1);
            count = Integer.valueOf(sub) + 1 + (length - 1) * (int) Math.pow(10, length - 2);
            count += numberOf1Between1AndN(sub);
        } else if (str.charAt(0) > '1') {
            String sub = str.substring(1);
            count = (int) Math.pow(10, length - 1) + (str.charAt(0) - '0') * (length - 1) * (int) Math.pow(10, length - 2);
            count += numberOf1Between1AndN(sub);
        }
        return count;
    }

    public static void main(String[] args) {
        Test43 test43 = new Test43();
        int result = test43.NumberOf1Between1AndN_Solution(55);
        System.out.println(result);
    }

}
