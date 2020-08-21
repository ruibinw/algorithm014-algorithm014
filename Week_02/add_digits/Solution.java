package add_digits;

/**
 * 循环
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public int addDigits(int num) {
        while (num >= 10) {
            num = (num / 10) + (num % 10);
        }
        return num;
    }
}

/**
 * 递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution2 {
    public int addDigits(int num) {
        if (num < 10) return num;
        num = (num / 10) + (num % 10);
        return addDigits(num);
    }
}

/**
 * 数学推导
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
class Solution3 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
