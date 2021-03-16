import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_318 {
    public static void main(String[] args) {
        String[] words = {"ab", "cd"};
        System.out.println(new Solution_318().maxProduct(words));
    }

    public int maxProduct(String[] words) {
        int ans = 0;
        List<Integer> masks = new ArrayList<>();
        Arrays.stream(words).forEach(it -> {
            int mask = 0;
            for (int i = 0; i < it.length(); i++) {
                char c = it.charAt(i);
                mask |= Integer.parseInt("1" + "0".repeat(c - 'a'), 2);
            }
            masks.add(mask);
        });
        for (int i = 0; i < masks.size(); i++) {
            for (int j = i + 1; j < masks.size(); j++) {
                if ((masks.get(i) & masks.get(j)) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}