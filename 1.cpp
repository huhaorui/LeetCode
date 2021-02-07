#include <vector>
#include <map>

using namespace std;


class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        vector<int> ans;
        map<int, int> num;
        for (int x = 0; x < nums.size(); x++) {
            num.insert(pair<int, int>(nums[x], x));
        }
        for (int x = 0; x < nums.size(); x++) {
            int key = target - nums[x];
            if (num.count(key) == 1 && x != num.find(x)->second) {
                ans.push_back(x);
                ans.push_back(num.find(x)->second);
                return ans;
            }
        }
        return ans;
    }
};