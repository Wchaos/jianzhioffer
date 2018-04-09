package practice.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by wch on 2018/3/31.
 */

/**
 * 字符串的全排列
 */
public class Test38 {

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str != null) {
            char[] strArr = str.toCharArray();
            permutationCore(strArr, 0, result);
        }
        Collections.sort(result); //排序
        return  result;
    }

    private static void permutationCore(char[] strArr, int index, ArrayList<String> result) {
        if (strArr == null || strArr.length == 0 || index < 0 || index >= strArr.length) {
            return;
        }
        if (index == strArr.length - 1) {
            result.add(String.valueOf(strArr));
        } else {
            char temp = strArr[index];
            for (int i = index; i < strArr.length; i++) {
                if (i == index || strArr[i] != strArr[index]) { //去重
                    //交换两个位置的元素
                    strArr[index] = strArr[i];
                    strArr[i] = temp;
                    permutationCore(strArr, index + 1, result); //递归交换下一个字符
                    //复原交换前的数组，以便下次交换
                    strArr[i] = strArr[index];
                    strArr[index] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> result = Permutation(str);
        System.out.println(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
