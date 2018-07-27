class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m = len(nums1)
        n = len(nums2)
        i1, i2 = 0, 0
        preValue = 0
        nowValue = 0
        targetIndex = (m + n) // 2
        i_c = 0

        while i_c <= targetIndex:
            if i1<m and (i2 >= n or nums1[i1] < nums2[i2]):
                preValue = nowValue
                nowValue = nums1[i1]
                i1 += 1
            else:
                preValue = nowValue
                nowValue = nums2[i2]
                i2 += 1
            i_c += 1
        if (m + n) % 2 == 1:
            return nowValue
        else:
            return (nowValue + preValue) / 2


s = Solution()
print(s.findMedianSortedArrays([1, 3], [2]))
print(s.findMedianSortedArrays([1, 2], [3, 4]))
print(s.findMedianSortedArrays([2],[]))
