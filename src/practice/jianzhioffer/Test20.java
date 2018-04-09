package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/27.
 */
public class Test20 {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length <= 0) return false;
        int index = 0;
        //判断是否有符号
        if(str[index] == '+' || str[index] == '-'){
            index++;
        }
        //如果只有符号位，则不是正确的数字
        if (index == str.length) return false;
        //扫描数字
        index = scanDigits(str,index);
        if (index < str.length){
            //如果有小数
            if (str[index] == '.'){
                index++;
                index = scanDigits(str,index);
                //如果有指数表示的形式
                if (index < str.length){
                    if (str[index] == 'e' || str[index] == 'E'){
                        index++;
                        return isExponential(str,index);
                    }
                    return false;
                }
                return true;
            }else if (str[index] == 'e' || str[index] == 'E'){
                //如果没有小数，且有指数形式
                index++;
                return isExponential(str,index);
            }
            return false;
        }
        return true;
    }

    private boolean isExponential(char[] str, int index) {
        if (index < str.length){
            //如果是符号，跳到下一个
            if (str[index] == '+' || str[index] == '-'){
                index++;
            }
            index = scanDigits(str,index);
            if (index == str.length) return true;
            return false;
        }
        return false;
    }

    private int scanDigits(char[] str, int index) {
        while (index < str.length && str[index] >= '0' && str[index] <= '9') index++;
        return index;
    }


}
