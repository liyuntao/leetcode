package leetcode;

/**
 * Created by amour on 14-2-23.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] bs = s.split("\\s+");
        return bs==null || bs.length==0 ? 0 : bs[bs.length-1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord(" "));
    }
}
