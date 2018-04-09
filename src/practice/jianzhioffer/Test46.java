package practice.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wch on 2018/4/3.
 */
public class Test46 {
    /**
     * 动态规划
     * f(abcde) = f(bcde)+(10<=ab<=25? f(cde):0)
     * 记住中间结果
     * @param num
     * @return
     */
    public static int getTranslationCount(int num){
        if(num<0){
            return 0;
        }
        String str = String.valueOf(num);
        Map<String,Integer> tempResult = new HashMap<>();
        return getTranslationCount(str,tempResult);

    }
    private static int getTranslationCount(String str, Map<String,Integer> tempResult){
        if(str == null|| str.length() == 0){
            return 0;
        }
        if(str.length()==1){
            return 1;
        }else {
            int count;
            String sub1 = str.substring(1);
            if(tempResult.containsKey(sub1)){
                count= tempResult.get(sub1);
            }else {
                count = getTranslationCount(sub1, tempResult);
            }
            String sub2 = str.substring(2);
            int num2 = Integer.valueOf(str.substring(0, 2));
            if(num2>=10 && num2 <=25){
                if(tempResult.containsKey(sub2)){
                    count += tempResult.get(sub2);
                }else {
                    count += getTranslationCount(sub2, tempResult);
                }
            }
            tempResult.put(str,count);
            return count;
        }
    }

    /**
     * 基于递推的动态规划
     * 从下到上解决问题
     * @param num
     * @return
     */
    public static int getTranslationCount_solution2(int num){
        if(num < 0){
            return 0;
        }
        String str = String.valueOf(num);
        return getTranslationCount_solution2(str);
    }
    private static int getTranslationCount_solution2(String str){
        if(str == null||str.length() == 0){
            return 0;
        }
        int length = str.length();
        int[] count = new int[length];

        for (int i = length-1; i >=0; i--) {
            if(i == length-1){
                count[i] = 1;
            }else {
                int num = Integer.valueOf(str.substring(i,i+2));
                if(num >=10 && num<= 25){
                    if(i==length-2){
                        count[i] = count[i+1]+1;
                    }else{
                        count[i] = count[i+1]+count[i+2];
                    }
                }else{
                    count[i]= count[i+1];
                }

            }

        }
        return count[0];
    }





    public static void main(String[] args) {
        int num = 12258;
        int result = getTranslationCount_solution2(num);
        System.out.println(result);
    }


}
