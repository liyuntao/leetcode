package leetcode;

/**
 * Created by amour on 14-3-5.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int total=0;
        int start=0;
        for(int i=0;i<gas.length;i++) {
            sum+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(sum < 0) {
                start=(i+1)%gas.length;
                sum=0;
            }
        }

        if(total <0)
            return -1;
        else
            return start;
    }

    public static void main(String[] args) {
        GasStation obj = new GasStation();
    }
}
