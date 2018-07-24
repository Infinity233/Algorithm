class Solution:
    def maxArea(self, height):
        maxV = 0
        i = 0
        j = len(height) - 1

        while i < j:
            t = (j - i) * min(height[i], height[j])
            maxV = max(maxV, t)
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1

        return maxV


s = Solution()
print(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))

# O（n^2）算法python超市 java通过
