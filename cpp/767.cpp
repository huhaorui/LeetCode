#include <iostream>

using namespace std;

class Solution {
public:
    static string reorganizeString(string S) {
        int num[26] = {0};
        int sum = S.length(), max = 0;
        for (char x : S) {
            num[x - 'a']++;
        }
        for (int x = 0; x < 26; x++) {
            if (num[x] > num[max]) max = x;
        }
        int times = sum - num[max];
        if (num[max] <= (sum + 1) / 2) {
            string ans;
            for (int x = 0; x < num[max]; x++) {
                ans.push_back('a' + max);
                if (times != 0) {
                    for (int y = 0; y < 26; y++) {
                        if (y != max && num[y] != 0) {
                            ans.push_back('a' + y);
                            num[y]--;
                            break;
                        }
                    }
                    times--;
                }
            }
            while (times != 0) {
                for (int y = 25; y >= 0; y--) {
                    if (y != max && num[y] != 0) {
                        ans.push_back('a' + y);
                        num[y]--;
                        break;
                    }
                }
                times--;
                if (times == 0) break;
                for (int y = 0; y < 26; y++) {
                    if (y != max && num[y] != 0) {
                        ans.push_back('a' + y);
                        num[y]--;
                        break;
                    }
                }
                times--;
            }
            return ans;
        } else {
            return "";
        }
    }
};
