package powx_n;

/**
 * 暴力法
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution1 {
    public double pow(double x, int n) {
        int res = 1;
        while (n-- > 0) {
            res *= x;
        }
        return res;
    }
}

/**
 * 分治思想
 * 时间复杂度: O(logn)，递归的层数
 * 空间复杂度: O(logn)，递归使用的栈空间
 */
class Solution2 {
    public double myPow(double x, int n) {
        long b = n; //int 的范围是 [-2^31, 2^31-1]，当 n = -2^31, 执行 n = -n 会溢出，所以转成 long
        return n > 0 ? pow(x, n) : 1 / pow(x, -b);
    }

    private double pow(double x, long b) {
        if (b == 0) return 1;
        double y = pow(x, b >> 1); //b >> 1 = b / 2
        return (b & 1) == 0 ? y * y : y * y * x; // b & 1 = b % 2
    }
}
