#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        int i = 0, j = numbers.size() - 1;
        while (target != numbers[i] + numbers[j]) {
            if (target > numbers[i] + numbers[j]) {
                i++;
            } else {
                j--;
            }
        }
        vector<int> ans;
        ans.push_back(i + 1);
        ans.push_back(j + 1);
        return ans;
    }
};