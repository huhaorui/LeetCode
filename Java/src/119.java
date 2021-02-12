import java.util.ArrayList;
import java.util.List;

class Solution_119 {
    public static void main(String[] args) {
        Solution_119 solution = new Solution_119();
        System.out.println(solution.getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        var ans = new ArrayList<Integer>();
        ans.add(1);
        if (rowIndex == 0)
            return ans;
        for (int i = 1; i <= rowIndex / 2; i++) {
            ans.add(Math.toIntExact(((long) ans.get(i - 1) * (rowIndex - i + 1) / i)));
        }
        for (int i = (rowIndex - 1) / 2; i >= 0; i--) {
            ans.add(ans.get(i));
        }
        return ans;
    }
}
