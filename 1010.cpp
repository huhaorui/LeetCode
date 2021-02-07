#include <vector>

using namespace std;

class Solution {
public:
    int numPairsDivisibleBy60(vector<int> &time) {
        int num[60] = {0}, sum = 0;
        for (int n:time) {
            num[n % 60]++;
        }
        //60+60
        sum += (num[0] - 1) * num[0] / 2;
        //30+30
        sum += (num[30] - 1) * num[30] / 2;
        //(1-29)+(31-59)
        for (int x = 1; x <= 29; x++) {
            sum += num[x] * num[60 - x];
        }
        return sum;
    }
};