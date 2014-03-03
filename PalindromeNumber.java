package leetcode;

/**
 * Created by amour on 14-3-3.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reverse = 0;
        int original = x;

        while(original != 0) {
            reverse = reverse*10 + original%10;
            original = original/10;
        }
        return x==reverse;
    }

    public static void main(String[] args) {
        PalindromeNumber obj = new PalindromeNumber();
        System.out.println(obj.isPalindrome(12344321));
        System.out.println(obj.isPalindrome(123421));
        System.out.println(obj.isPalindrome(-12321));
    }
}
