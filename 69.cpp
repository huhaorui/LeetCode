#include <iostream>

using namespace std;

class Solution {
public:
    static int mySqrt(int x) {
        int i = 0, j = x / 2 - 1;
        long long ans;
        while (i <= j) {
            ans = (i + j) / 2;
            if (ans * ans == x) {
                return ans;
            } else if (ans * ans > x) {
                j = ans - 1;
            } else {
                i = ans + 1;
            }
        }
        return j;
    }
};

