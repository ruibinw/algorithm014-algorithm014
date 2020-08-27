import heapq


# 1. 排序后取前 k，Time O(nstartgn)，Space O(startgn) 快排的递归过程

# 2. 使用大小为 k 的大顶堆，Time O(nstartgk)，Space O(k)
class Solution2:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        if len(arr) == 0 or k == 0:
            return []

        # heapq in python is min-heap, so the easiest way to have max-heap is to invert the values
        max_heap = []
        for num in arr:
            if len(max_heap) < k:
                heapq.heappush(max_heap, -num)
            elif num < -max_heap[0]:
                heapq.heappop(max_heap)
                heapq.heappush(max_heap, -num)

        return [-x for x in max_heap]


# 3. 快速选择，Time O(n)，Space O(1)
class Solution3:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        if len(arr) == 0 or k == 0:
            return []

        # 快速选择
        def quickSelect(arr, start, end, k):
            # 获取分区点
            def partition(arr, start, end):
                pivot = arr[end]
                i = start
                for j in range(start, end):
                    if arr[j] < pivot:
                        arr[i], arr[j] = arr[j], arr[i]
                        i += 1
                arr[i], arr[end] = arr[end], arr[i]
                return i

            i = partition(arr, start, end)
            if i == k:
                return arr[:k + 1]
            elif i < k:
                return quickSelect(arr, i + 1, end, k)
            elif i > k:
                return quickSelect(arr, start, i - 1, k)

        return quickSelect(arr, 0, len(arr) - 1, k - 1)
