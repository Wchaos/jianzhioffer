package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/1.
 */

import java.util.ArrayList;

/**
 * 字符串的全组合
 */
public class Test38_1 {

    public static ArrayList<String> combination(char[] charArr){
        ArrayList<String> result = new ArrayList<>();

        for (int len = 1; len <= charArr.length; len++) {
            StringBuffer sb = new StringBuffer();
            combinationCore(charArr,0,len,sb,result);
        }
        return result;
    }

    public static void combinationCore(char[] charArr, int index, int len,StringBuffer sb, ArrayList<String> result){

        if(charArr == null||len <0||charArr.length-index<len){
            return;
        }
        if(len == 0){
            if(sb!= null && sb.length() >0) {
                result.add(sb.toString());
            }
        }else {
            sb.append(charArr[index]);
            combinationCore(charArr, index + 1, len - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1); //回溯
            combinationCore(charArr, index + 1, len, sb, result);
        }

    }

    public static void main(String[] args) {
        char[] charArr = {'a','b','c'};
        ArrayList<String> res = combination(charArr);
        for (String str : res){
            System.out.println(str);
        }
    }



}
