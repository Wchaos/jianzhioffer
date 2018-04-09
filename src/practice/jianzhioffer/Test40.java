package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/1.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 */
public class Test40 {

    public ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k || input.length == 0 || k <= 0) {
            return result;
        }
        //构建最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                maxHeap.offer(input[i]);
            } else if (input[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        while (!maxHeap.isEmpty()){
            result.add(maxHeap.poll());
        }
        return result;
    }










    /**
     * 还是基于快速排序的思想
     * 时间复杂度为O(N)，但是会改变数组
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k || input.length == 0 || k <= 0) {
            return result;
        }
        int left = 0;
        int right = input.length - 1;
        int baseIndex = partition(input, left, right);
        while (baseIndex != k - 1) {
            if (baseIndex < k - 1) {
                left = baseIndex + 1;
                baseIndex = partition(input, left, right);
            } else {
                right = baseIndex - 1;
                baseIndex = partition(input, left, right);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }

        return result;
    }


    private int partition(int[] array, int left, int right) {
        int base = array[left];
        while (left < right) {
            while (left < right && array[right] >= base) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= base) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = base;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        Test40 test40 = new Test40();
        ArrayList<Integer> res = test40.GetLeastNumbers(nums, 4);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }


}
