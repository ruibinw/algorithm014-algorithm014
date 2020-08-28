# 暴力法：合并再排序
class Solution1:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        nums1[:] = nums1[:m] + nums2
        nums1.sort()


# 双指针
class Solution2:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        i, j, k = m - 1, n - 1, m + n - 1
        while i >= 0 and j >= 0:
            if nums1[i] > nums2[j]:
                nums1[k] = nums1[i]
                i, k = i - 1, k - 1
            else:
                nums1[k] = nums2[j]
                j, k = j - 1, k - 1
        while j >= 0:
            nums1[k] = nums2[j]
            j, k = j - 1, k - 1