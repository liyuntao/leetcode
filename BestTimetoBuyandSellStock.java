package leetcode;

/**
 * Created by amour on 14-3-23.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int lowest = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i-1] < lowest) lowest = prices[i-1];
            if(prices[i] - lowest > maxProfit) maxProfit =  prices[i] - lowest;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock obj = new BestTimetoBuyandSellStock();
        System.out.println(obj.maxProfit(new int[]{3,5,2,7,1,9,6,10}));
    }
}
