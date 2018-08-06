class Solution:
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        range = 1
        i = 0
        count = 0
        while range < n:
            if i < len(nums) and nums[i] <= range:
                range += nums[i]
                i += 1
            else:
                count += 1
                range *= 2
        return count


s = Solution()
print(s.minPatches([], 8))
