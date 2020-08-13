package swap_nodes_in_pairs;

import linked_list.ListNode;

//https://leetcode-cn.com/problems/swap-nodes-in-pairs/

/**
 * 递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
}

/**
 * 迭代
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode first = head, second = first.next, third = second.next;
            prev.next = second;
            second.next = first;
            first.next = third;
            prev = first;
            head = third;
        }
        return dummy.next;
    }
}
