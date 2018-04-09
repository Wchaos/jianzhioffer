package practice.jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wch on 2018/4/2.
 */
public class Test41 {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();


    public static void Insert(Integer num) {


        int size = maxHeap.size() + minHeap.size();
        if ((size & 1) == 0) {  //之前前size为偶数，当前数插入到最大堆
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                int min = minHeap.poll();
                minHeap.offer(num);
                maxHeap.offer(min);
            } else {
                maxHeap.offer(num);
            }
        } else {   //之前size为奇数，当前数插入最小堆
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                int max = maxHeap.poll();
                maxHeap.offer(num);
                minHeap.offer(max);
            } else {
                minHeap.offer(num);
            }
        }
    }

    public static Double GetMedian() throws Exception {
        int size = maxHeap.size() + minHeap.size();
        if (size == 0) {
            throw new Exception("No numbers are available");
        }
        double median = 0;
        if ((size & 1) != 0) {  //size为奇数，中位数在最大堆的堆顶
            median = (double) maxHeap.peek();
        } else {
            median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        return median;
    }

    public static void main(String[] args) {
        int nums[] = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int num : nums) {
            Insert(num);
            try {
                System.out.println(GetMedian());
            } catch (Exception e) {
                System.out.println(e.getCause());
            }

        }
    }
}

