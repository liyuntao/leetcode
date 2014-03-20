package leetcode;

/**
 * Created by amour on 14-3-20.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] ori = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder("");
        for(int i=ori.length-1;i>=0;i--) {
            sb.append(ori[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString obj = new ReverseWordsInAString();
        System.out.println(obj.reverseWords(" the sky is blue "));
    }
}
