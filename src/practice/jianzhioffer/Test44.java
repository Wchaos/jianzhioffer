package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/2.
 */

/**
 * 数字序列中某一位的数字
 */
public class Test44   {

    /**
     * 区间及对应占序列中的宽度：
     * 0~9：10*1
     * 10~99：90*2
     * 100~999：900*3
     * 算出索引在哪一区间
     * 从而算出索引代表哪个数的哪一位
     * 比如1001，在100~199区间：(1001-10-180)=811=270*3+1，所以1001代表100~199区间的第270个数（即370）的中间一位
     *
     * @param index
     * @return
     */
    public static int digitAtIndex(int index){

        if(index<10){
            return index;
        }
        index-=10;
        int len = 2;
        int gap;
        while(true){
            gap = 9*(int)Math.pow(10,len-1)*len;
            if(index <gap) {
                break;
            }else {
                index -= gap;
                len++;
            }
        }
        int num = index/len +(int)Math.pow(10,len-1);
        int indexInNum = index%len;
        int result = String.valueOf(num).charAt(indexInNum)-'0';

        return result;
    }

    public static void main(String[] args) {
        int index = 190;
        System.out.println(digitAtIndex(index));
    }
}
