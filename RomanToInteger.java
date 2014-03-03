package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amour on 14-3-3.
 */
public class RomanToInteger {
    Map<Character, Integer> m = new HashMap<Character, Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        if(s == null || s.length()==0) return 0;

        char[] c = s.toCharArray();
        int result = m.get(c[c.length-1]);
        for(int i=c.length-2; i>=0; i--) {
            if(m.get(c[i]) >= m.get(c[i+1])) {
                result += m.get(c[i]);
            }else {
                result -= m.get(c[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt("CCXIII")); //213
        System.out.println(obj.romanToInt("")); //0
        System.out.println(obj.romanToInt(null)); //0
        System.out.println(obj.romanToInt("CDXXXV")); //435
        System.out.println(obj.romanToInt("DCCXCIV")); //794
    }
}
