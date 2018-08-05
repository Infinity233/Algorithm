class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i, j = 0, 0
        while j < len(nums):
            while j + 1 < len(nums) and nums[j] == nums[j + 1]:
                j += 1
            nums[i] = nums[j]
            i += 1
            j += 1
        return i


s = Solution()
nums = [0,0,1,1,1,2,2,3,3,4]
print(s.removeDuplicates(nums))
print(nums)
