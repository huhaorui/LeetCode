#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
struct numCD {
    int num;
    int cd = 0;
};

bool cmp(numCD &n1, numCD &n2) {
    return n1.num > n2.num;
}

class letter {
private:
    numCD num[26];
    int n, time;
public:
    letter(vector<char> &tasks, int n) {
        this->n = n + 1;
        time = tasks.size();
        for (auto &i : num) {
            i.num = 0;
        }
        for (char c:tasks) {
            num[c - 'A'].num++;
        }
        sort(num, num + 26, cmp);
    }

    bool get() {
        if (time == 0) return false;
        sort(num, num + 26, cmp);
        for (int x = 0; x <= 25; x++) {
            if (num[x].num == 0) {
                break;
            }
            if (!num[x].cd) {
                num[x].num--;
                num[x].cd = n;
                time--;
                break;
            }
        }
        for (int x = 0; x < 25; x++) {
            if (num[x].cd) {
                num[x].cd--;
            }
        }
        return true;
    }
};

class Solution {
public:
    int leastInterval(vector<char> &tasks, int n) {
        letter l(tasks, n);
        int ans = 0;
        while (l.get()) {
            ans++;
        }
        return ans;
    }
};

/*
 * 剩余次数最多的任务肯定要先做
 */