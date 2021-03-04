import java.util.ArrayList;
import java.util.Arrays;

class Envelope {
    private int width;
    private int length;

    public Envelope(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}

class Solution_354 {
    public static void main(String[] args) {
        int[][] envelop = new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        System.out.println(new Solution_354().maxEnvelopes(envelop));
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1) {
            return 1;
        }
        ArrayList<Envelope> envelope = new ArrayList<>();
        for (int[] ints : envelopes) {
            envelope.add(new Envelope(ints[0], ints[1]));
        }
        envelope.sort((o1, o2) -> {
            if (o1.getWidth() != o2.getWidth()) {
                return o1.getWidth() - o2.getWidth();
            }
            return o1.getLength() - o2.getLength();
        });
        int ans = 0;
        int[] DP = new int[envelope.size()];
        Arrays.fill(DP, 1);
        for (int i = 1; i < envelope.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelope.get(j).getLength() < envelope.get(i).getLength() && envelope.get(j).getWidth() != envelope.get(i).getWidth()) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            ans = Math.max(ans, DP[i]);
        }
        envelope.forEach(System.out::println);
        return ans;
    }
}