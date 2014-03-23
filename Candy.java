package leetcode;

/**
 * Created by amour on 14-3-22.
 */
public class Candy {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for(int i=1; i<candy.length; i++) {
            candy[i] = 1;
            if(ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            }
        }

        for(int i=candy.length-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
                candy[i] = candy[i+1] + 1;
            }
            sum+=candy[i];
        }
        return sum+candy[candy.length-1];
    }

    public static void main(String[] args) {
        Candy obj = new Candy();
        System.out.println(obj.candy(new int[]{1,7,5,9,8,2,6,3}));
        System.out.println(obj.candy(new int[]{4,2,3,4,1}));
    }
}
