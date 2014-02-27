package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amour on 14-2-23.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
       Map<Integer, Integer> m = new HashMap<Integer, Integer>();// num => index

       Integer[] specialResult = new Integer[2];
       for(int i=0; i<numbers.length; i++){
           if(target%2 == 0 && numbers[i] == target/2) {
               if(specialResult[0] == null){
                   specialResult[0] = i+1;
               }else{
                   specialResult[1] = i+1;
                   return new int[]{specialResult[0], specialResult[1]};
               }
               continue;
           }
           m.put(numbers[i], i);
       }

        for(int num : m.keySet()){
            if(m.containsKey(target - num)) {
                int a = m.get(num)+1;
                int b = m.get(target - num)+1;
                return a > b? new int[]{b, a} : new int[]{a, b};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(new int[]{5,4,9,4,11}, 8);
        System.out.println(result[0]+"  "+result[1]);
    }
}
