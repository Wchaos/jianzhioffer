package practice.jianzhioffer;

import java.util.Stack;

/**
 * Created by wch on 2018/3/22.
 */

/**
 * 用两个栈实现"先进先出"队列的pop和push操作，
 * @param <T>
 */
public class Test9 <T>{

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void push(T value){
        this.stack1.push(value);
    }

    public T pop()throws Exception{
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
            throw new Exception("栈为空！");
        }
        while(!stack1.empty()){
            this.stack2.push(stack1.pop());
        }
        return this.stack2.pop();
    }

}
