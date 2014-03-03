package leetcode;

/**
 * Created by amour on 14-3-3.
 */
public class StringToInteger {
    public int atoi(String str) {
        if(str == null || str.length() == 0) return 0;
        boolean hasSymbol = false;
        boolean negative = false;
        char[] c = str.trim().toCharArray();
        if(c[0] == '+' || c[0] == '-') {
            hasSymbol = true;
            if(c[0] == '-') negative = true;
        }

        long result = 0;
        for(int i = hasSymbol?1:0; i<c.length; i++) {
            if(c[i] < '0' || c[i] > '9') {
               break;
            }
            result = result*10 + c[i]-('9'-9) ;
        }
        if(result > 2147483647) {
            return negative? -2147483648: 2147483647;
        }else {
            return (int)(negative? -1*result : result);
        }
    }

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();
        System.out.println('9'-9);
        System.out.println(obj.atoi("-798"));
        System.out.println(obj.atoi("71232194"));
        System.out.println(obj.atoi("  -010 "));
        System.out.println(obj.atoi("  -010fi938 "));
        System.out.println(obj.atoi("2147483648"));
        System.out.println(obj.atoi("  -99999999999"));
    }
}
