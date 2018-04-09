package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/21.
 */

/**
 * 替换空格
 */
public class Test5 {
    public static String replaceBlank(String str){
        return str.replace(" ","%20");
    }

    public static void main(String[] args) {
        String str = "We are happy";
        String newStr = replaceBlank(str);
        System.out.println(newStr);
    }
}
