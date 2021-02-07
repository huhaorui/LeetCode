#include <vector>

using namespace std;

class Solution {
public:
    int climbStairs(int n) {
        vector<int> ans;
        ans.push_back(1);
        ans.push_back(2);
        for (int x = 2; x < n; x++) {
            ans.push_back(ans[x - 1] + ans[x - 2]);
        }
        return ans[n-1];
    }
};