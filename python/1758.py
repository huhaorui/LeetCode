class Solution:
    def minOperations(self, s: str) -> int:
        length = len(s)
        ans1 = 0
        ans2 = 0
        to_compare = "01" * int(length / 2)
        if length % 2 == 1:
            to_compare = to_compare + "0"
        for i in range(0, length):
            if to_compare[i] != s[i]:
                ans1 += 1
        to_compare = "10" * int(length / 2)
        if length % 2 == 1:
            to_compare = to_compare + "1"
        for i in range(0, length):
            if to_compare[i] != s[i]:
                ans2 += 1
        return min(ans2, ans1)


if __name__ == '__main__':
    solution = Solution()
    print(solution.minOperations("1111111"))
