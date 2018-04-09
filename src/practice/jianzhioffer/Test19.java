package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/27.
 */

/**
 * 正则表达式匹配
 *
 * 思想：递归
 * 情况分析：1、正常匹配，或者'.'号匹配，直接匹配下一个字符
 *           2、模式串下一个字符为'*'号，可以根据当前字符是否匹配分为两种情况：
 *           2-1、当前字符不匹配，*号代表0次当前字符
 *           2-2、当前字符匹配，又分为三种情况：
 *           2-2-1、*号后面有足够当前字符能匹配，*号代表0次当前字符
 *           2-2-1、*号匹配字符，消掉字符差当前字符，直到变成情况2-2-1或2-2-3
 *           2-2-3、*号把当前字符开始的相同字符匹配完了，跳过模式匹配下一个字符
 *
 *
 * 难点：1、递归边界条件的确定
 *       2、多种情况的递归分析
 */
public class Test19 {

    public boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);

    }

    public boolean matchCore(String str, String pattern, int strIndex, int patIndex) {
        //两个都达到了字符串末尾，匹配成功，返回true
        if (strIndex >= str.length() && patIndex >= pattern.length()) {
            return true;
        }
        //模式已经到达末尾，但是字符串未结束，返回false
        if(strIndex < str.length()&& patIndex >= pattern.length()){
            return false;
        }
        //模式串未到达末尾，字符串可能结束可能未结束
        //模式下一个符号是*的情况
        if (patIndex+1 < pattern.length()&&pattern.charAt(patIndex + 1) == '*') {
            //字符串结束，只有模式串后面为*号模式，才有比较下去的必要
            if(strIndex >= str.length()){
                return matchCore(str,pattern,strIndex,patIndex+2);
            }
            //当前符号不匹配，*号表示模式当前符号出现零次，模式patIndex+2,继续匹配
            if (str.charAt(strIndex) != pattern.charAt(patIndex) && pattern.charAt(patIndex) != '.') {
                return matchCore(str, pattern, strIndex, patIndex + 2);
            } else { //当前符号匹配，存在三种情况
                return (matchCore(str, pattern, strIndex, patIndex + 2) //*号模式后面足够多与str当前字符匹配的字符，*号模式表示0次，patIndex +2
                        || matchCore(str, pattern, strIndex + 1, patIndex) //*号模式开始匹配多个str当前字符，一个个消掉str字符，strIndex+1
                        || matchCore(str, pattern, strIndex + 1, patIndex + 2));//str下一个符号匹配不到*号模式,*号模式用完，strIndex+1，patIndex +2
            }
        }
        //下一个不是*号时，正常匹配当前字符
        if (str.charAt(strIndex) == pattern.charAt(patIndex)|| pattern.charAt(patIndex) == '.') {
            return matchCore(str, pattern, strIndex + 1, patIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "baaaab";
        String pat = "ba*ab";
        Test19 test19 = new Test19();
        boolean res = test19.match(str,pat);
        System.out.println(res);
    }


}
