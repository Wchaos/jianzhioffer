package practice.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by wch on 2018/4/7.
 */


/**
 * 队列的最大值
 * 定义一个队列，并实现max函数得到队列最大值，要求函数addLast、removeFirst、getMax的时间复杂度都时O(1)
 */
public class Test59_1 {

    static class Element{
        int val;
        int pos;
        Element(int value,int position){
            this.val = value;
            this.pos = position;
        }
    }

    static class QueueWithMax{
        Deque<Element> dataQueue = new LinkedList<>();
        Deque<Element> maxQueue = new LinkedList<>();
        Integer currentIndex = 0;

        public void addLast(int value){
            while (!maxQueue.isEmpty()&&value>=maxQueue.getLast().val){
                maxQueue.removeLast();
            }
            Element element = new Element(value,currentIndex);
            dataQueue.addLast(element);
            maxQueue.addLast(element);
            currentIndex++;
        }
        public void removeFirst(){
            if(dataQueue.isEmpty()||maxQueue.isEmpty()){
                throw new NoSuchElementException();
            }
            if(dataQueue.getFirst().pos == maxQueue.getFirst().pos){
                maxQueue.removeFirst();
            }
            dataQueue.removeFirst();
        }
        public int getMax(){
            if(maxQueue.isEmpty()){
                throw new NoSuchElementException();
            }
            return maxQueue.getFirst().val;
        }
    }


}
