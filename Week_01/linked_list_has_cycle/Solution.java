package linked_list_has_cycle;

import linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/linked-list-cycle/

/**
 * 哈希表记录
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}

/**
 * 快和慢指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
