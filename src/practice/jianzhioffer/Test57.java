package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/5.
 */

import java.util.ArrayList;

/**
 * 排序数组中和为S的两个数字,如果有多对，输出成绩最小的那对
 */
public class Test57 {
    /**
     * 定义两个指针，一个指向数组前首部，一个指向数组尾部
     * 计算两个指针指向数字的和，
     * 如果小于目标，则为尾部指针向左移动，
     * 如果大于目标，则首部指针向右移动。
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum_solution(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array != null) {
            int pre = 0;
            int back = array.length - 1;

            while (pre < back) {
                if (array[pre] + array[back] > sum) {
                    back--;
                } else if (array[pre] + array[back] < sum) {
                    pre++;
                } else {
                    result.add(array[pre]);
                    result.add(array[back]);
                    break;
                }
            }
        }
        return result;
    }


    /**
     * 暴力 时间复杂度O(N)
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array != null) {
            int firNum;
            int secNum;
            for (int i = 0; i < array.length; i++) {
                firNum = array[i];
                secNum = sum - array[i];
                if (secNum < 0) {
                    break;
                }
                for (int j = i + 1; j < array.length; j++) {
                    if (secNum == array[j]) {
                        result.add(firNum);
                        result.add(secNum);
                        return result;
                    }
                }
            }
        }
        return result;
    }


}
