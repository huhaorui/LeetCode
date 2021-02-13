#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    static int findMaxConsecutiveOnes(vector<int> &nums) {
        int max = 0, num = 0;
        for (int i : nums) {
            if (i == 1)
                num++;
            else
                num = 0;
            if (max < num)
                max = num;
        }
        return max;
    }
};
