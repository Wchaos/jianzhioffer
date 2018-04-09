package practice.jianzhioffer;


/**
 * Created by wch on 2018/4/6.
 */

import java.util.*;

/**
 * 滑动窗口的最大值
 * 输入一个数组和一个滑动窗口的大小
 * 输出所有滑动窗口中的最大值
 * 比如：输入数组[2,3,4,2,6,2,5,1]和滑动窗口大小3
 *       输出{4,4,6,6,6,5}(总共存在6个滑动窗口)
 */
public class Test59 {

    static class Element{
        int val;
        int pos;
        Element(int value,int position){
            this.val = value;
            this.pos = position;
        }
    }

    /**
     * 思路：考虑建立一个最大堆，每次将当前元素加入堆，这样就能直接从最大堆读出最大值，
     *        但是已经滑出窗体的值可能影响窗体内最大值的判断，需要删除堆中不在窗体内的值
     * 出现问题：堆内只存元素值，无法判断元素是否在窗体内，还要存元素的位置信息
     * 解决办法：创建一个类用来保存元素的值和位置信息，堆用来保存该类对象
     * @param array
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows2(int[] array, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || size <= 0 || array.length < size) {
            return result;
        }
        PriorityQueue<Element> maxHeap = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                Integer val1 = o1.val;
                Integer val2 = o2.val;
                return val2.compareTo(val1);
            }
        });
        for (int i = 0; i < array.length; i++) {
            maxHeap.offer(new Element(array[i],i)); //将当前元素加入堆
            while (!maxHeap.isEmpty()&&(i-maxHeap.peek().pos)>=size){ //堆顶元素不在窗内时，删除
                maxHeap.poll();
            }
            if(i>=size-1&&!maxHeap.isEmpty()){
                result.add(maxHeap.peek().val);
            }
        }
        return result;
    }


    /**
     * 使用一个双端队列来保存当前窗体的最大值和之后窗体可能的最大值
     * 同时每次移动判断队首的最大值是否被移除窗体，是，则删除，队列后面的值称为当前窗体最大值
     * @param array
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int[] array, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || size <= 0 || array.length < size) {
            return result;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) { //array[i]表示当前进入窗体的数
            while (!queue.isEmpty() && array[i] >= array[queue.getLast()]) { //如果之前保存的窗体最大值小于当前值，
                queue.removeLast();   //则之前的值不可能为当前窗和后续窗的最大值，删除
            }
            queue.addLast(i); //由于后续值未知，当前值无论如何都有成为之后窗体最大值的可能，加入队列
            if (i - queue.getFirst() >= size) {
                queue.removeFirst();  //队列之前保存的最大值被移出窗外了，删除
            }
            if (i >= size - 1)
                result.add(array[queue.getFirst()]); //队列首部始终是当前窗体的最大值，加入结果
        }
        return result;
    }



    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> res = maxInWindows(arr, size);
        System.out.println(res.toString());
        ArrayList<Integer> res2 = maxInWindows2(arr, size);
        System.out.println(res2.toString());

    }
}
