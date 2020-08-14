class Solution1:
    def has_cycle(self, head: ListNode) -> bool:
        visited = set()
        while head:
            if head in visited:
                return True
            visited.add(head)
            head = head.next
        return False


class Solution2:
    def has_cycle(self, head: ListNode) -> bool:
        if not (head and head.next):
            return False
        slow, fast = head.next, head.next.next
        while slow != fast:
            if not (fast and fast.next):
                return False
            slow, fast = slow.next, fast.next.next
        return True