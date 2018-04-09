package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/3.
 */

/**
 * 最长不含重复字符的子字符串
 */
public class Test48  {

    /**
     * 动态规划
     * 与之前求累加和最大的子字符串一个道理
     * 从第一个字符（beginIndex = 0）开始统计(i++)，每次尝试更新最大长度(i-beginIndex+1是否大于之前的maxLen)
     * 如果当前字符(i)与区间(beginIndex~(i-1))内索引为j的字符重复，，更新beginIndex=j+1;
     * @param str
     * @return
     */
    public static int longestSubstringWithoutDuplication(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int beginIndex = 0;
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            for (int j = beginIndex; j < i; j++) {
                if(cur == str.charAt(j)){
                    beginIndex = j+1;
                    break;
                }
            }

            if(maxLen < i-beginIndex+1){
                maxLen = i-beginIndex+1;
            }
        }
        return maxLen;
    }

    /**
     * 书上思路
     * 思路其实和上面差不多，差别在于建立了一个长度为26的数组用于辅助判重
     * @param str
     * @return
     */
    public static int longestSubstring_solution2(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int curLen = 0;
        int maxLen = 0;
        int[] position = new int[26];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            int preIndex = position[cur-'a'];

            if(preIndex<0||i-preIndex>curLen){  //没遇到过当前字符或者当前长度不足以覆盖重复字符，不影响长度增长
                curLen++;
            }else{  //当前字符重复，保存之前长度，加入当前字符，更新当前长度
                if(maxLen < curLen){
                    maxLen = curLen;
                }
                curLen = i-preIndex;
            }
            position[cur-'a'] = i;
            if(maxLen < curLen){
                maxLen = curLen;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String str = "arabcacfr";
        String str1 = "abcdebfghijk";
        String str2 = "bbbbbbb";
        int length = longestSubstringWithoutDuplication(str);
        System.out.println(length);
        int length1 = longestSubstringWithoutDuplication(str1);
        System.out.println(length1);
        int length2 = longestSubstringWithoutDuplication(str2);
        System.out.println(length2);

    }



}
