class Solution {
public:
    int kthGrammar(int N, int K) {
        if (N != 1)
            return ((kthGrammar(N - 1, (K + 1) / 2)) + K % 2 + 1) % 2;
        return 0;
    }
};