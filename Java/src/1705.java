import java.util.Comparator;
import java.util.PriorityQueue;

class Apple {
    int date;
    int amount;

    public Apple(int date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public Apple decrease() {
        amount--;
        return this;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "date=" + date +
                ", amount=" + amount +
                '}';
    }
}

class Solution_1705 {
    public static void main(String[] args) {
        int[] apples = new int[]{2, 1, 10};
        int[] days = new int[]{2, 10, 1};
        System.out.println(new Solution_1705().eatenApples(apples, days));
    }

    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<Apple> apple = new PriorityQueue<>(Comparator.comparing(o -> o.date));
        int length = apples.length;
        int i;
        for (i = 0; i < length; i++) {
            apple.add(new Apple(days[i] + i - 1, apples[i]));
            while (!apple.isEmpty() && (apple.peek().date < i || apple.peek().amount <= 0)) {
                apple.poll();
            }
            if (apple.isEmpty()) {
                continue;
            }
            apple.add(apple.poll().decrease());
            ans++;
        }
        while (!apple.isEmpty()) {
            while (!apple.isEmpty() && (apple.peek().date < i || apple.peek().amount <= 0)) {
                apple.poll();
            }
            if (apple.isEmpty()) {
                return ans;
            }
            apple.add(apple.poll().decrease());
            ans++;
            i++;
        }
        return ans;
    }
}