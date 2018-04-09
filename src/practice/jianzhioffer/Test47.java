package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/3.
 */
public class Test47 {
    /**
     * 动态规划
     * 将到达矩阵(m*n)右下角的大问题，分解为到达途中每一点的小问题
     * 但是如果直接递归会出现大量重复计算
     * 创建一个与矩阵同等大小的二维数组记住每个点的结果，避免重复计算；
     * 时间复杂度：O(m*n),空间复杂度O(m*n)
     * @param gift
     * @return
     */
    public int getMaxValue(int[][] gift){
        if(gift == null|| gift.length == 0 || gift[0].length == 0){
            return 0;
        }
        int rows = gift.length;
        int cols = gift[0].length;
        int[][] maxValue = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int leftMaxValue = 0;
                int upMaxValue = 0;
                if(j > 0) {
                    leftMaxValue = maxValue[i][j-1];
                }
                if(i>0) {
                    upMaxValue = maxValue[i - 1][j];
                }
                int preMaxValue = leftMaxValue < upMaxValue ? upMaxValue: leftMaxValue;
                maxValue[i][j] = gift[i][j] + preMaxValue;
            }
        }
        return maxValue[rows-1][cols-1];
    }

    /**
     * 动态规划
     * 思路和上面一样，但是存储中间结果做了优化
     * 创建一个与矩阵每行长度大小相等的一维数组
     * 每次记录上一行的最优值，每读取当前行数值，逐渐将数组记录为当前行的最优值，然后开始下一行迭代
     * 时间复杂度不变，空间复杂度变为O(m)
     * @param gift
     * @return
     */
    public int getMaxValue_solution2(int[][] gift){
        if(gift == null|| gift.length == 0 || gift[0].length == 0){
            return 0;
        }
        int rows = gift.length;
        int cols = gift[0].length;
        int[] maxValue = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int leftMaxValue = 0;
                int upMaxValue = 0;
                if(j>0){
                    leftMaxValue = maxValue[j-1];
                }
                if(i>0){
                    upMaxValue = maxValue[j];
                }
                int preMaxValue = leftMaxValue < upMaxValue ? upMaxValue: leftMaxValue;
                maxValue[j] = gift[i][j] + preMaxValue;
            }
        }
        return maxValue[cols-1];
    }
}
