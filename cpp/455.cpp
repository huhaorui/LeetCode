#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int findContentChildren(vector<int> &g, vector<int> &s) {
        if (s.empty()) return 0;
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int seat = -1, num = 0;
        for (int child:g) {
            seat++;
            while (seat < s.size() && child > s[seat]) {
                seat++;
            }
            if (seat == s.size() - 1) break;
            num++;
        }
        return num;
    }
};