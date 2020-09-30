package number_of_1_bits;

/**
 * 检查每一位
 */
class Solution1 {
    // n is treated as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) count++;
            n >>= 1;
        }
        return count;
    }
}

/**
 *  把数字 n 的最后一个 1 反转为 0， count + 1，直到 n 变成 0
 */
class Solution2 {
    // n is treated as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
