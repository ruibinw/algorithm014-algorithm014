package reverse_linked_list;

import linked_list.ListNode;

//https://leetcode.com/problems/reverse-linked-list/

/**
 * 迭代反转
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

/**
 * 递归反转
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
