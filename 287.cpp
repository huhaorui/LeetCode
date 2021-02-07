#include <vector>

using namespace std;

class Solution {
public:
    int findDuplicate(vector<int> &nums) {
        int i = 1, j = nums.size() - 1;
        while (i != j) {
            int m = (i + j) / 2, count = 0;
            for (int num:nums) {
                if (num <= m) count++;
            }
            if (count > m) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
};

/*
 * 5,1,2,3,4,5,5,7,8,9,10,11
 * 在1-11中寻找
 * 重复的数是6或更小嘛？
 * 数一数发现，<=6的数有7个，说明重复的数<=6
 * 那去1-6中寻找
 * 重复的数<=3嘛？
 * <=3的数只有三个，没问题，重复的数比3大
 * 在4-5中寻找
 * 重复的数<=4嘛？
 * 比4小的数有四个，重复的数比4大
 * 所以，重复的数是5
 */