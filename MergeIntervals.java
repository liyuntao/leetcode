package leetcode;

import leetcode.common.Interval;

import java.util.ArrayList;

/**
 * Created by amour on 14-2-23.
 */
public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        return null;
    }

    boolean cmp(Interval i1, Interval i2) {
        if(i1.start < i2.start) {
            return true;
        }else if(i1.start == i2.start && i1.end < i2.end) {
            return true;
        }
        return false;
    }

}

