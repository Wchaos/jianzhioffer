package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/6.
 */

/**
 * 翻转字符串
 * 翻转英文句子中单词的顺序，但是单词内字符不变（标点符号和普通字母处理）
 * 如："I am a student." 变为："student. a am I"
 *
 */
public class Test58 {
    /**
     * 完全没有体现出题者意图的解法。。。
     * 实在不能忍受java中用字符数组去表示字符串。。。
     * @param str
     * @return
     */
    public static String reverseSentence(String str){
        if(str == null ){
            return null;
        }
        String[] strArr = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strArr.length-1; i >= 0; i--) {
            sb.append(strArr[i]);
            sb.append(" ");
        }
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 书上解法：先反转整个字符串，再将每个单词反转过来
     * 书上的字符串是用字符数组表示的，主要是想考空间复杂度为O(1)时，怎么翻转字符串。
     *
     * 本题扩展题：左旋转字符串：
     * 输入字符串"abcdefg"和数字2；输出字符串"cdefgab"
     * 思路和本题类似：1、先将前半部分（ab）和后半部分分别反转；2、再将整个字符串反转。两步顺序颠倒亦然
     * @param str
     * @return
     */
    public static String reverseSentence2(String str){
        if(str == null){
            return null;
        }
        char[] charArr = str.toCharArray();
        reverse(charArr,0,charArr.length-1);  //反转整个句子
        int left = 0, right = 0;
        while(left < charArr.length){
            if(right == charArr.length || charArr[right] == ' '){
                reverse(charArr,left,right-1); //反转单词
                left = ++right;
            }
            right++;
        }
        return String.valueOf(charArr);
    }
    //反转字符串中的left~right的一段
    private static void reverse(char[] arr,int left, int right){
        if(arr == null ||  left < 0 || left > right || right>=arr.length){
            return;
        }
        while (left < right){
             char temp  = arr[left];
             arr[left] = arr[right];
             arr[right] = temp;
             left++;
             right--;
        }
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.println(reverseSentence(str));
        System.out.println(reverseSentence2(str));
    }




}
