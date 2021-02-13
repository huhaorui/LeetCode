#include <vector>
#include <hash_map>

using namespace std;
using namespace __gnu_cxx;

class Solution {
public:
    vector<int> intersect(vector<int> &nums1, vector<int> &nums2) {
        hash_map<int, int> num, num2;
        vector<int> ans;
        for (auto n:nums1) {
            num[n]++;
        }
        for (auto n:nums2) {
            if (num.find(n) != num.end() && num[n] != 0) {
                num[n]--;
                ans.push_back(n);
            }
        }
        return ans;
    }
};