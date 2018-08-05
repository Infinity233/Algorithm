class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i, j = 0, 0
        while j < len(nums):
            while j < len(nums) and nums[j] == val:
                j += 1
            if j >= len(nums):
                break
            nums[i] = nums[j]
            i += 1
            j += 1
        return i


s = Solution()
nums = [0,1,2,2,3,0,4,2]
print(s.removeElement(nums, 2))
print(nums)
