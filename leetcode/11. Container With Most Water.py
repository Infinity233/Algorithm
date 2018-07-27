class Solution:
    def maxArea(self, height):
        maxV = 0
        i = 0
        j = len(height) - 1

        while i < j:
            t = (j - i) * min(height[i], height[j])
            maxV = max(maxV, t)
            if height[i] < height[j]:
                tt = height[i]
                i += 1
                while i < j and height[i] < tt:
                    i += 1
            else:
                tt = height[j]
                j-=1
                while i < j and height[j] < tt:
                    j -= 1

        return maxV


s = Solution()
print(s.maxArea([1,2,4,3]))

# O（n^2）算法python超市 java通过
