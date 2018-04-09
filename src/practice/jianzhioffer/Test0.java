package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/20.
 */

/**
 * 长度为n的数组，元素在0~n-1之间，寻找重复的元素
 */
public class Test0 {
    /**
     * 字符串转数字
     * @param str
     * @return
     */
    public int strToInt(String str) {
        //考虑空指针
        if (str == null) {
            throw new ArithmeticException("输入字符串为空指针");
        } else {
            int len = str.length();
            int sum = 0;
            int signed = 1;
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                //考虑正负号
                if (i == 0 && (c == '+' || c == '-')) {
                    signed = (c == '-' ? -1 : 1);
                }else {
                    //考虑非数字字符输入
                    if ('9' <= c || c <= '0') {
                        throw new ArithmeticException("输入字符串含非数字字符串：" + str);
                    } else {
                        sum = sum * 10 + (c - '0');
                    }
                }

            }
            return signed*sum;
        }
    }



    public static void main(String[] args) {
        String str = new String("aaa");
        Test0 test0 = new Test0();
        int num = test0.strToInt(str);
        System.out.println(num);
    }
}
