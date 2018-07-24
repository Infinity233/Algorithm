class Solution:
    def isPalindrome(self, x):
        x = str(x)
        x2 = x[len(x) // 2:]
        x2 = x2[::-1]
        x = x[:len(x) // 2 + 1]

        return x == x2