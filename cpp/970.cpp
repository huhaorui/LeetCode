#include <vector>
#include <set>
#include <cmath>

using namespace std;

class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        set<int> num;
        if (x != 1 && y != 1) {
            for (int i = 0; i <= log(bound) / log(x); i++) {
                for (int j = 0; j <= log(bound - pow(x, i) / log(y)); j++) {
                    if (bound >= pow(x, i) + pow(y, j))
                        num.insert(pow(x, i) + pow(y, j));
                }
            }
        } else if (x == 1 && y == 1) {
            if (bound >= 2)
                num.insert(2);
        } else if (x == 1) {
            for (int j = 0; j <= log(bound - 1) / log(y); j++) {
                num.insert(pow(y, j) + 1);
            }
        } else {
            for (int i = 0; i <= log(bound - 1) / log(x); i++) {
                num.insert(pow(x, i) + 1);
            }
        }
        vector<int> ans;
        ans.assign(num.begin(), num.end());
        return ans;
    }
};