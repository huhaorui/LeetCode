class Solution {
    public static void main(String[] args) {
        int[] row = new int[]{3, 0, 1, 4, 2, 5};
        System.out.println(new Solution().minSwapsCouples(row));
    }

    public int minSwapsCouples(int[] row) {
        int length = row.length;
        int ans = 0;
        for (int i = 0; i < length; i += 2) {
            if ((row[i] ^ row[i + 1]) != 1) {
                int toFind = row[i] ^ 1;
                for (int j = i + 2; j < length; j++) {
                    if (row[j] == toFind) {
                        int tmp = row[j];
                        row[j] = row[i + 1];
                        row[i + 1] = tmp;
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}