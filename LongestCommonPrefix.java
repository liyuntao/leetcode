package leetcode;

/**
 * Created by amour on 14-2-23.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String result = getCommonPrefix(strs[0], strs[1]);
        for(int i=2; i<strs.length;i++) {
            result = getCommonPrefix(result, strs[i]);
        }
        return result;
    }

    String getCommonPrefix(String str1, String str2) {
        if(str1.length()==0 || str2.length()==0) return "";
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        for(int i = 0, max = c1.length>c2.length?c2.length:c1.length; i < max; i++) {
            if(c1[i] == c2[i]) {
                continue;
            }else {
                if(i == 0) return "";
                return str1.substring(0, i);
            }
        }
        return c1.length>c2.length? str2:str1;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(new String[]{"123123123", "123123122", "1231231234"}));
    }
}
