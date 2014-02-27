package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amour on 14-2-23.
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target)
    {
        int []a = new int[2];
        Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++)
        {
            //put number into hash table (if it's not already there)
            Integer n = nums.get(numbers[i]);
            if (n==null) nums.put(numbers[i], i); //subtract array element from target number
            n = nums.get(target-numbers[i]);
            if (n!=null && n<i)
            {//if such number exists in the table return the indicies
                a[0]=n+1;
                a[1]=i+1;
                return a;
            }
        }
        return a;
    }
}
