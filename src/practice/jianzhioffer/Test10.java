package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/22.
 */
public class Test10 {
    /**
     * 递归存在大量重复计算，速度特别慢，且可能出现栈溢出1
     * @param n
     * @return
     */
    public int Fib1(int n ){
        if(n<=0){
            return 0;
        }
        if(n == 1){
            return 1;
        }else{
            return Fib1(n-1)+Fib1(n-2);
        }
    }
    public int Fib2(int n){
        int fibN = 0;

        if (n==1){
            fibN = 1;
        }
        int fibPrePre = 0;
        int fibPre = 1;

        if(n>=2){
            for (int i = 2; i <=n ; i++) {
                fibN = fibPrePre+fibPre;
                fibPrePre = fibPre;
                fibPre = fibN;
            }
        }
        return fibN;

    }


}
