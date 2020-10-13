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
        ListNode first = head, second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
}

/**
 * 迭代
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 为了让第一队的状态和其他的一样，需要使用哨兵节点指向第一个节点
 */
class Solution2 {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        head = prev;
        while (head.next != null && head.next.next != null) {
            ListNode first = head.next, second = first.next, third = second.next;
            head.next = second;
            second.next = first;
            first.next = third;
            head = first;
        }
        return prev.next;
    }
}
