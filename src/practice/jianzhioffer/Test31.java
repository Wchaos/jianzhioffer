package practice.jianzhioffer;

import java.util.Stack;

/**
 * Created by wch on 2018/3/28.
 */

/**
 * 判断出栈序列是否与入栈序列匹配
 */
public class Test31 {

    /**
     * 将每次弹出的元素，和栈顶元素比较，相等则弹出
     * 不相等，压入下一个元素比较
     * 如果不相等，且没有元素可压栈，则匹配失败
     * @param pushNums
     * @param popNums
     * @return
     */
    public static boolean isPopOrder(int[] pushNums,int[] popNums){
        if(pushNums == null|| popNums == null|| pushNums.length != popNums.length|| pushNums.length == 0){
            return false;
        }
        int lenth = pushNums.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0,j = 0;
        while(j<lenth){
            if(!stack.empty()&&popNums[j] == stack.peek()){ //当前出栈元素在栈顶，弹出该元素，比较下一个出栈元素
                stack.pop();
                j++;
            }else if(i<lenth){  //栈为空或者当前出栈元素不在栈顶时，压入下一个元素
                stack.push(pushNums[i]);
                i++;
            }else { //入栈序列中没有下一个元素可压，不匹配
                return false;
            }
        }
        return true; //每一个出栈元素都匹配，返回true
    }

    public static void main(String[] args) {
       int[] pushNums = {1,2,3,4,5};
       int[] popNums1 = {4,3,2,5,1};//true
       int[] popNums2 = {4,5,3,2,1};//true
       int[] popNums3 = {1,2,3,4,5}; //true
       int[] popNums4 = {4,3,5,1,2}; //false

       boolean res = isPopOrder(pushNums,popNums1);
        boolean res1 = isPopOrder(pushNums,popNums2);
        boolean res2 = isPopOrder(pushNums,popNums3);
        boolean res3 = isPopOrder(pushNums,popNums4);
       System.out.println(res);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }



}
