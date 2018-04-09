package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/23.
 */
public class Test12 {
    public boolean hasPath(char[] matrix, int rows, int cols, String str) {
        if (matrix == null || str == null) {
            return false;
        }
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, String str, int strIndex, boolean[] flag) {
        int index = row * cols + col;
        //位置越界，矩阵上的点已经进入过，字符不匹配，直接返回false
        if (row < 0 || row >= rows || col < 0 || col >= cols || flag[row * rows + col] || strIndex >= str.length() || str.charAt(strIndex) != matrix[index]) {
            return false;
        }
        //字符匹配的情况下，长度符合，则说明路径找到了
        if (strIndex == str.length() - 1) {
            return true;
        }
        //字符匹配，进入该点，标志为true
        flag[index] = true;
        if (hasPathCore(matrix, rows, cols, row + 1, col, str, strIndex + 1, flag) ||
                hasPathCore(matrix, rows, cols, row - 1, col, str, strIndex + 1, flag) ||
                hasPathCore(matrix, rows, cols, row, col + 1, str, strIndex + 1, flag) ||
                hasPathCore(matrix, rows, cols, row, col - 1, str, strIndex + 1, flag))
        {
            return true;
        }
        //该点后续没有匹配的，回溯，跳出该点，标志改为false
        flag[index] = false;
        return false;
    }

}
