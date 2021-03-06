package fibonacci_number;

/**
 * 递归
 * Time：O(2^n)
 * Time：O(n)
 */
class Solution1 {
    public int fib(int N) {
        return N < 2 ? N : fib(N - 1) + fib(N - 2);
    }
}

/**
 * 递归 + 缓存
 * Time：O(n)
 * Time：O(n)
 */
class Solution2 {
    public int fib(int N) {
        return fib(N, new int[N + 1]);
    }
    private int fib(int n, int[] cache) {
        if (n < 2)
            return n;
        if (cache[n] != 0)
            return cache[n];
        cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
        return cache[n];
    }
}

/**
 * 动态规划
 * Time：O(n)
 * Time：O(1)
 */
class Solution3 {
    public int fib(int N) {
        if (N < 2) return N;

        int a0 = 0, a1 = 1, aN = 1;
        for (int i = 2; i < N; i++) {
            a0 = a1;
            a1 = aN;
            aN = a0 + a1;
        }
        return aN;
    }
}
