class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        if (len(nums) < 3):
            return res

        len_2 = len(nums) - 2
        len_1 = len(nums) - 1
        nums = sorted(nums)

        i = 0
        while i < len_2:
            if nums[i] > 0:
                break
            if i != 0 and nums[i] == nums[i - 1]:
                i += 1
                continue
            sum = 0 - nums[i]
            left, right = i + 1, len_1
            while left < right:
                t = nums[left] + nums[right]
                if t == sum:
                    res += [nums[i], nums[left], nums[right]],
                    while left < right and nums[left + 1] == nums[left]:
                        left += 1
                    left += 1
                    while left < right and nums[right - 1] == nums[right]:
                        right -= 1
                    right -= 1
                elif t < sum:
                    while left < right and nums[left + 1] == nums[left]:
                        left += 1
                    left += 1
                else:
                    while left < right and nums[right - 1] == nums[right]:
                        right -= 1
                    right -= 1
            i += 1
        return res


s = Solution()
print(s.threeSum([-1, 0, 1, 2, -1, -4]))
