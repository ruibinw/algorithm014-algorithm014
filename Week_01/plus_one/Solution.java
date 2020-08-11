package plus_one;

//https://leetcode-cn.com/problems/plus-one/

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--)
            if ((digits[i] = ++digits[i] % 10) != 0)
                return digits;
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
