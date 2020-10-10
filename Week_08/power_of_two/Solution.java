package power_of_two;

/**
 * 2 的幂次方的二进制只有一个 1
 */
class Solution1 {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1 && ++count > 1) return false;
            n >>= 1;
        }
        return count == 1;
    }
}

/**
 * 2 的幂次方去除二进制最右边的 1 (n & (n - 1)) 后，会等于 0
 */
class Solution2 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

/**
 * 获取二进制最右边的 1
 * 如果 n 是 2 的幂次方，(n & -n) == n
 */
class Solution3 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
}

