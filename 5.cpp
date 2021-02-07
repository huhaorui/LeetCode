#include <iostream>

using namespace std;

class Solution {
public:
    static string longestPalindrome(string s) {
        if (s.length() == 0) return "";
        bool dp[1000][1000] = {{false}};
        int max = 0;
        string ans;
        for (int x = s.length(); x >= 0; x--) {
            for (int y = x; y < s.length(); y++) {
                if (y - x < 2) {
                    dp[x][y] = s[x] == s[y];
                } else {
                    dp[x][y] = dp[x + 1][y - 1] && (s[x] == s[y]);
                }
                if (dp[x][y] && y - x + 1 > max) {
                    max = y - x + 1;
                    ans = s.substr(x, y - x + 1);
                }
            }
        }
        return ans;
    }
};

/*
 * 第i到第j个char能否构成回文取决于
 * 1.第i+1到第j-1个char是否回文
 * 2.第i个char和第j个char是否相同
 * dp[i][j]=dp[i+1][j-1]&&s[i]==s[j]
 */