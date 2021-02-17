import java.util.ArrayList;
import java.util.List;

class Solution_1291 {
    public static void main(String[] args) {
        System.out.println(new Solution_1291().sequentialDigits(89, 234));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        int[] map = new int[]{12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789};
        int[] increase = new int[]{11, 111, 1111, 11111, 111111, 1111111, 11111111, 123456789};
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            if (low <= map[i] && high >= map[i]) {
                ans.add(map[i]);
            }
            int count = 0;
            while (map[i] + increase[i] <= high && count < 7 - i) {
                map[i] += increase[i];
                if (low <= map[i] && high >= map[i]) {
                    ans.add(map[i]);
                }
                count++;
            }
            if (high < map[i])
                break;
        }
        return ans;
    }
}