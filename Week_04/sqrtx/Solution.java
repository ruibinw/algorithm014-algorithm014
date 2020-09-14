package sqrtx;

/**
 * 暴力法
 * Time：O(n)
 */
class Solution1 {
    public int mySqrt(int x) {
        for (long i = 1; i <= x; i++) {
            if (i * i > x) return (int) i - 1;
        }
        return x; //when x = 0 or 1 return 0 or 1 respectively
    }
}

/**
 * 二分法
 * Time：O(logn)
 */
class Solution2 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x)
                right = mid - 1;
            else
                left = mid;
        }
        return (int) left;
    }
}
