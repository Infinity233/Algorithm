class Solution:

    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []

        def generate(a, b, str):
            if a == 0 and b == 0:
                res.append(str)
                return
            if a == b:
                generate(a - 1, b, str + '(')
            elif a == 0 and b > 0:
                generate(a, b - 1, str + ')')
            elif a < b:
                generate(a - 1, b, str + '(')
                generate(a, b - 1, str + ')')

        generate(n, n, "")
        return res


s = Solution()
print(s.generateParenthesis(1))
print(s.generateParenthesis(2))
print(s.generateParenthesis(3))
    