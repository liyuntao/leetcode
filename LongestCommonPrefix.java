package leetcode;

/**
 * Created by amour on 14-2-23.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String defau = "";
        if(strs.length == 0) return defau;
        int least_length = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].length() < least_length) least_length = strs[i].length();
        }
        if(least_length == 0) return defau;

        
        for(int i = least_length; i>0; i--){
            for(int j=0; j<strs.length; j++){
                if(false){

                }else{
                    break;
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
    }
}
