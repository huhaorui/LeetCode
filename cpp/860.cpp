#include <vector>

using namespace std;

class Solution {
public:
    bool lemonadeChange(vector<int> &bills) {
        int five = 0, ten = 0;
        for (int bill:bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    ten++;
                    if (!five) {
                        return false;
                    } else {
                        five--;
                    }
                    break;
                case 20:
                    if (!five) {
                        return false;
                    } else if (ten) {
                        ten--;
                        five--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
};