#include <vector>
#include <algorithm>

using namespace std;

class point {
public:
    int x, y, d;

    point(int x, int y) {
        this->x = x;
        this->y = y;
        d = x * x + y * y;
    }
};

bool cmp(point &p1, point &p2) {
    return p1.d < p2.d;
}

class Solution {
public:
    static vector<vector<int>> kClosest(vector<vector<int>> &points, int K) {
        vector<point> p;
        p.reserve(points.size());
        for (vector<int> P:points) {
            p.emplace_back(P[0], P[1]);
        }
        sort(p.begin(), p.end(), cmp);
        vector<vector<int>> ans;
        for (int x = 0; x < K; x++) {
            vector<int> tmp;
            tmp.push_back(p[x].x);
            tmp.push_back(p[x].y);
            ans.push_back(tmp);
        }
        return ans;
    }
};