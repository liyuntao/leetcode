package leetcode;

/**
 * Created by liyuntao on 2014/6/16.
 * 还有点小问题。越写越烂。。
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        SubArray a = new SubArray(A, 0, A.length-1);
        SubArray b = new SubArray(B, 0, B.length-1);
        return findMedianSortedArrays(a, b);
    }

    private double findMedianSortedArrays(SubArray a, SubArray b) {
        if(a.getLength() == 0) {
            return getMedianFromOneArray(b);
        }

        if(b.getLength() == 0) {
            return getMedianFromOneArray(a);
        }

        int sum = a.getLength() + b.getLength();
        if(sum % 2 == 0) {
            return (findKth(a, b, sum/2 ) + findKth(a, b, sum/2 + 1) ) / 2.0;
        } else {
            return findKth(a, b, sum/2 + 1);
        }
    }

    private double getMedianFromOneArray(SubArray arr) {
        if(arr.getLength() % 2 == 0) {
            return (arr.get(arr.getLength()/2 -1) + arr.get(arr.getLength()/2))/2.0;
        } else {
            return arr.get(arr.getLength()/2);
        }
    }

    private double findKth(SubArray a, SubArray b, int k) {
        if(a.getLength() > b.getLength()) {
            return findKth(b, a, k); //只考虑a <= b的情况
        }

        if(k/2 <= a.getLength()) {
            if(k == 1) {
                return a.get(0) < b.get(0) ? a.get(0): b.get(0);
            }
            int n1 = a.get(k/2 - 1);
            int n2 = b.get(k/2 - 1);
            if(n1 > n2) {
                SubArray b1 = new SubArray(b.getArray(), b.start + k/2, b.end);
                return findKth(a, b1, k - k/2);
            } else if(n1 < n2) {
                SubArray a1 = new SubArray(a.getArray(), a.start + k/2, a.end);
                return findKth(a1, b, k - k/2);
            } else {
                //return n2; //TODO 仅当K<=sum/2时可行
                if(k%2 == 0) {
                    return n2;
                } else { // TODO 越界风险
                    if(k/2 == a.getLength()) {
                        return b.get(k/2);
                    } else {
                        return a.get(k/2) < b.get(k/2) ? a.get(k/2) : b.get(k/2);
                    }
                }
            }
        } else {
            int n1 = a.get(a.getLength() - 1);
            int n2 = b.get(k - a.getLength() - 1);
            if(n1 > n2) {
                SubArray b1 = new SubArray(b.getArray(), b.start + k - a.getLength(), b.end);
                return findKth(a, b1, a.getLength());
            } else if(n1 <= n2) {
                if(n1 < n2) {
                    return n2;
                } else if (n1 == n2 && k % 2 ==0) {
                    return n2;
                } else {
                    return b.get(k - a.getLength());
                }
            }
        }
        return -1;
    }

    class SubArray {
        int[] array;
        int start;
        int end;
        SubArray(int[] oriArray, int start, int end) {
            this.array = oriArray;
            this.start = start;
            this.end = end;
        }

        int get(int i) {
            if(start + i <= end) {
                return array[start + i];
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        int getLength() {
            return end - start + 1 > 0 ? end - start + 1 : 0;
        }

        int[] getArray() {
            return array;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        int A[] = {11000};
        int B[] = {11001};
        System.out.println(obj.findMedianSortedArrays(A, B));

        int C[] = {1,2};
        int D[] = {1,2};
        System.out.println(obj.findMedianSortedArrays(C, D));

        int E[] = {1};
        int F[] = {2,3,4,5,6,7,8};
        System.out.println(obj.findMedianSortedArrays(E, F));
    }
}
