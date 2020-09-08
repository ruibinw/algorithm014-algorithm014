package valid_perfect_square;

/**
 * 二分查找
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;
            long square = mid * mid;
            if (square < num)
                lo = mid + 1;
            else if (square > num)
                hi = mid - 1;
            else
                return true;
        }
        return false;
    }

    //不用 long
    public boolean isPerfectSquare2(int num) {
        int lo = 1, hi = num;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int res = num / mid, remain = num % mid;
            if (res == mid && remain == 0)
                return true;
            if (res > mid)
                lo = mid + 1; //mid is small, increase mid
            else
                hi = mid - 1; //mid is big, decrease mid
        }
        return false;
    }
}

/**
 * 数学推导：牛顿迭代法 x2 = (x1 + num/x1) / 2
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public boolean isPerfectSquare(int num) {
        long x = num, res;
        while ((res = x * x) > num) {
            x = (x + num /x) >> 1;
        }
        return res == num;
    }
}
