package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/25.
 */

import java.util.Scanner;

/**
 * 机器人的运动范围
 */
public class Test13 {

    public int movingCount(int threshold, int rows, int cols){
        int count = 0;
        if(threshold <0 || rows <= 0 || cols <= 0){
            return 0;
        }
        boolean[] flag = new boolean[rows*cols];
        movingCountCore(threshold,rows,cols,0,0,flag);

        //统计flag数组上为true的位置数
        for (int i = 0; i < flag.length; i++) {
            if(flag[i]){
                count++;
            }
        }
        return count;
    }

    /**
     * 符合条件就将flag数组对应位置置为true
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param flag
     */
    public void movingCountCore(int threshold, int rows, int cols, int row, int col,boolean[] flag){
        int index = row*cols+col;
        if(row >= 0&& row <rows&& col >= 0&& col <cols&& !flag[index]) {
            int sum = sumOfDigits(row) + sumOfDigits(col);
            if (sum <= threshold) {
                flag[index] = true;
                movingCountCore(threshold,rows,cols,row+1,col,flag);
                movingCountCore(threshold,rows,cols,row-1,col,flag);
                movingCountCore(threshold,rows,cols,row,col+1,flag);
                movingCountCore(threshold,rows,cols,row,col-1,flag);
            }
        }
    }
    //获取数的各位上的数字之和
    public int sumOfDigits(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }


    public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入限制条件k:");
            int k = scanner.nextInt();
            System.out.println("请输入方格的行数m：");
            int m = scanner.nextInt();
            System.out.println("请输入方格的列数n:");
            int n = scanner.nextInt();

            Test13 solution1 = new Test13();

            scanner.close();
            System.out.println("矩阵能到达的方格数是：");
            System.out.println(solution1.movingCount(k, m, n));
        }

}
