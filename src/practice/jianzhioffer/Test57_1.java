package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/6.
 */


import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 */
public class Test57_1 {
    /**
     * 直接遍历取1~s/2之间的数为起点去找连续序列
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        int temp;
        int tempSum;
        for (int start = 1; start <= sum / 2; start++) {
            temp = start;
            tempSum = 0;
            while (tempSum < sum) {
                tempSum += temp;
                sequence.add(temp);
                temp++;
            }
            if (tempSum == sum && sequence.size() > 1) {
                result.add(new ArrayList<>(sequence));
            } else {
                sequence.clear();
            }
        }
        return result;
    }

    /**
     * 书上解法：
     * 思路其实也是一样的，但是定义了两个指针，减少了一些计算
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence_solution(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        if(sum>=3) {
            int start = 1;
            int end = 2;
            int curSum = start + end;
            sequence.add(start);
            sequence.add(end);
            while (start <= sum / 2) {
                if(curSum< sum) {
                    end++;
                    curSum += end;
                    sequence.add(end);
                }else{
                    if (curSum == sum) {
                        result.add(new ArrayList<>(sequence));
                    }
                    curSum -= start;
                    sequence.remove(sequence.indexOf(start));
                    start++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = FindContinuousSequence(9);
        System.out.println(result.toString());
    }
}
