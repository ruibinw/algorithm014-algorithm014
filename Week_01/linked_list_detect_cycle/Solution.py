# 哈希表记录
# Time: O(n)
# Space: O(n)
class Solution1:
    def detectCycle(self, head: ListNode) -> ListNode:
        visited = set()
        while head:
            if head in visited:
                return head
            visited.add(head)
            head = head.next
        return None


# 快和慢指针
# Time: O(n)
# Space: O(n)
class Solution2:
    def detectCycle(self, head: ListNode) -> ListNode:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            # 确定有环，一个指针从头开始走，另一个从相遇点开始走
            # 两个指针再次相遇的节点，就是入环的第一个节点
            if slow == fast:
                slow = head
                while slow != fast:
                    slow = slow.next
                    fast = fast.next
                return slow
        return None