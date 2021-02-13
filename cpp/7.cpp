#include <cmath>

class Solution {
public:
    int reverse(int x) {
        long long sum = 0, num = x;
        int flag = 1;
        if (num < 0) {
            flag = -1;
            num = -num;
        }
        while (num > 0) {
            sum = sum * 10 + num % 10;
            num /= 10;
        }
        if (sum > pow(2, 31)) {
            return 0;
        }
        return flag * sum;
    }
};