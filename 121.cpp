#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if (prices.empty()) return 0;
        int ans = 0, min = prices[0];
        for (int price:prices) {
            ans = max(ans, price - min);
            if (price < min) min = price;
        }
        return ans;
    }
};
/*
 * 到某天为止的最大盈利=max(前一天为止的最大盈利,如果今天卖出的最大盈利)
 * 注意没有任何交易日的特殊情况
 */