package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/4.
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 字符流中的第一个只出现一次的字符
 */
public class Test50_1 {

    private static int[] timesOfChar = new int[256];
    private static ArrayList<Character> charArr = new ArrayList<>();

    public static void insert(char input){
        if((timesOfChar[input]&1) == 0){  //字符之前出现次数为偶数时，将当前保存起来
            charArr.add(input);
        }else{
            charArr.remove(charArr.indexOf(input)); //字符之前出现次数为奇数时，当前字符抵消之前保存的相同字符
        }
        timesOfChar[input]++;

    }
    public static char FirstNotRepeatingCharInStream(){
        char result = '#';  //没有不重复字符是输出'#'
        if(charArr!=null&&charArr.size()>0){
            result = charArr.get(0);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] charArr =  str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            insert(charArr[i]);
            System.out.println(FirstNotRepeatingCharInStream());
        }

    }

}
