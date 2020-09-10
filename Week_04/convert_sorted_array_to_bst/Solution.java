package convert_sorted_array_to_bst;

import binary_tree.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfsConvert(nums, 0, nums.length - 1);
    }

    private TreeNode dfsConvert(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfsConvert(nums, left, mid - 1);
        node.right = dfsConvert(nums, mid + 1, right);
        return node;
    }
}
