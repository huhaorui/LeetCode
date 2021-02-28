class Solution_896 {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }
        int op = 0;
        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i - 1];
            if (op == 0) {
                op = diff;
            }
            if (op * diff < 0) {
                return false;
            }
        }
        return true;
    }
}