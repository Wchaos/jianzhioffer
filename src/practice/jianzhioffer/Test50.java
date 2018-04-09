package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/3.
 */

/**
 * 字符串中第一个只出现一次的字符
 * 返回其索引
 */
public class Test50 {

    public int FirstNotRepeatingChar(String str) {
        if(str == null||str.length() == 0){
            return -1;
        }
        int[] timesOfChar = new int[256];
        for (int i = 0; i < str.length(); i++) {
            timesOfChar[str.charAt(i)] += 1;
        }
        int minIndex = str.length();
        int index;
        for (int i = 0; i < timesOfChar.length; i++) {
            if(timesOfChar[i] == 1){
                index = str.indexOf(i);
                if(index<minIndex){
                    minIndex = index;
                }
            }
        }
        return minIndex == str.length()? -1:minIndex;

    }



}
