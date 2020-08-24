package rotate_array;

//https://leetcode-cn.com/problems/rotate-array/

/**
 * 暴力法，将每个元素移动 1步 k次
 * 时间复杂度：O(n*k)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotateOneStep(nums);
        }
    }
    private void rotateOneStep(int[] nums) {
        int last = nums[nums.length - 1];
        for (int j = nums.length - 1; j > 0; j--) {
            nums[j] = nums[j - 1];
        }
        nums[0] = last;
    }
}

/**
 * 环状替换，直接将每个元素放到最后的位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;//k>n时，移动 k 次 相当于移动 k%n 次
        int count = 0;
        for (int start = 0; count < n; start++) {
            int cur = start;
            int prevNum = nums[cur];
            do {
                int next = (cur + k) % n;
                int tmp = nums[next];
                nums[next] = prevNum;
                prevNum = tmp;
                cur = next;
                count++;
            } while (start != cur);
        }
    }
}

/**
 * 使用反转
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
