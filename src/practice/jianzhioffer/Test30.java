package practice.jianzhioffer;

import java.util.Stack;

/**
 * Created by wch on 2018/3/28.
 */


/**
 * 带O(1)时间复杂度min函数的栈类
 *
 * 思路：使用两个栈来实现新的栈类，数据栈存储据，辅助栈用于存每个状态对应的最小值，重写pop和push方法
 */
public class Test30 {
    class StackContainsMin<T extends Comparable>{
        Stack<T> datatack = new Stack<>();
        Stack<T> minStack = new Stack<>();

        public void push(T value){
            datatack.push(value);
            if(minStack.empty()){
                minStack.push(value);
            }else{
                T min = minStack.peek();
                if(value.compareTo(min)<0){
                    minStack.push(value);
                }else{
                    minStack.push(min);
                }
            }
        }
        public T pop(){
            T data = datatack.pop();
            minStack.pop();
            return data;
        }
        public T min(){
            return minStack.peek();
        }

    }

    public static void main(String[] args) {
        Test30 test30 = new Test30();
        //new内部类对象，需要依赖外部类对象
        StackContainsMin<Integer> stackContainsMin = test30.new StackContainsMin();

        //书上示例的操作
        stackContainsMin.push(3);
        System.out.println(stackContainsMin.min());
        stackContainsMin.push(4);
        System.out.println(stackContainsMin.min());
        stackContainsMin.push(2);
        System.out.println(stackContainsMin.min());
        stackContainsMin.push(1);
        System.out.println(stackContainsMin.min());
        stackContainsMin.pop();
        System.out.println(stackContainsMin.min());
        stackContainsMin.pop();
        System.out.println(stackContainsMin.min());
        stackContainsMin.push(0);
        System.out.println(stackContainsMin.min());
    }
}
