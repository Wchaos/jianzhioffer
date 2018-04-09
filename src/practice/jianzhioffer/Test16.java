package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/26.
 */

/**
 * 求浮点数的整数次幂
 * 注意点：1、浮点数等于0的情况判定
 *         2、求次幂使用递归更加高效
 */
public class Test16 {
    /**
     * 全面但是不够高效的解法
     * 浮点数判断相等，不能使用"=="，应先确定比较的精度，然后用"Math.abs(a-b)<精度" 去判断
     *
     * @param base
     * @param exponent
     * @return
     * @throws Exception
     */
    public double power (double base, int exponent)throws Exception{
        double precision = 0.000001;
        if(Math.abs(base)<precision&&exponent <0){
            throw new Exception("0的负数次幂无意义");
        }
        double result = 1.0;
        if (exponent>= 0){
            result = powerWithAbsExponent(base,exponent);
        }else{
            result = 1.0/powerWithAbsExponent(base,-exponent);
        }
        return  result;

    }

    /**
     * 简单的累乘求次幂方法
     * 时间复杂度位O(N)
     * @param base
     * @param absExponent
     * @return
     */
    public double powerWithAbsExponent(double base,int absExponent){
        double result = 1.0;
        for (int i = 1; i <= absExponent; i++) {
            result *= base;
        }
        return  result;
    }

    /**
     * 基于递归的高效的求次幂方法
     * 时间复杂度位O(logN)
     * @param base
     * @param absExponent
     * @return
     */
    public double powerWithAbsExponent2(double base,int absExponent){
        //指数位0的情况
        if (absExponent == 0){
            return 1.0;
        }
        //指数位1的情况
        if(absExponent == 1){
            return base;
        }
        //指数n>=2是，拆分成n/2次幂递归
        double result = powerWithAbsExponent(base,absExponent>>2);
        result *= result;
        //如果当前次幂位奇数，则需乘上一个base
        if((absExponent & 1) != 0){
            result *= base;
        }
        return result;
    }


}
