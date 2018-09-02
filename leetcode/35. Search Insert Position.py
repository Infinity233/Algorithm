class Solution:
    def searchInsert(self, nums, target):
        for i, v in enumerate(nums):
            if v == target:
                return i
            else:
                if i == 0:
                    if target <= v:
                        return 0
                elif nums[i - 1] <= target <= nums[i]:
                    return i
        return len(nums)

    def erfen(self, nums, target):
        l, r = 0, len(nums)
        while l < r:
            m = (l + r) // 2
            if nums[m] == target:
                return m
            else:
                if m == 0:
                    if target <= nums[m]:
                        return 0
                elif nums[m - 1] < target <= nums[m]:
                    return m
            if nums[m] > target:
                r = m
            else:
                l = m + 1
        return len(nums)


s = Solution()
assert(s.erfen([1, 3], 2) == 1)
assert(s.erfen([1, 3], 1) == 0)
assert(s.erfen([2, 5], 1) == 0)
assert(s.erfen([1,3,5,6], 5) == 2)
assert(s.erfen([1,3,5,6], 2) == 1)
assert(s.erfen([1,3,5,6], 7) == 4)
assert(s.erfen([1,3,5,6], 0) == 0)