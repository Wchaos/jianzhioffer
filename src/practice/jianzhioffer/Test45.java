package practice.jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wch on 2018/4/2.
 */
public class Test45 {

    public String PrintMinNumber(int [] numbers) {
        StringBuffer result = new StringBuffer();
        if(numbers == null){
            return result.toString();
        }
        List<String> numStrList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numStrList.add(String.valueOf(numbers[i]));
        }
        numStrList.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str1.compareTo(str2);
            }
        });

        for (int i = 0; i < numStrList.size(); i++) {
            result.append(numStrList.get(i));
        }
        return result.toString();
    }


}
