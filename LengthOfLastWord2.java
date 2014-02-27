package leetcode;

/**
 * Created by amour on 14-2-23.
 */
public class LengthOfLastWord2 {
    public int lengthOfLastWord(String s) {
        char[] c = s.toCharArray();
        int result = 0;
        if(c.length == 0) return 0;
        boolean isMetLetter = false;
        for(int i=c.length-1;i>=0;i--){
            if(c[i] == ' ' && !isMetLetter){
                continue;
            }else if(c[i] == ' ' && isMetLetter) {
                break;
            }else {
                isMetLetter = true;
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLastWord2 obj = new LengthOfLastWord2();
        System.out.println(obj.lengthOfLastWord(" "));
    }
}
