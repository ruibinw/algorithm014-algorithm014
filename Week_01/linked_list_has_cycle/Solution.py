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
        walker = head
        runner = head
        while runner and runner.next:
            walker = walker.next
            runner = runner.next.next
            if runner == walker:
                return True
        return False