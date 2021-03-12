import java.util.*;

class Two {
    Integer num;
    Integer depth;

    public Two(Integer num, Integer depth) {
        this.num = num;
        this.depth = depth;
    }
}

public class Alibaba_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), a, b, x, y, q;
        ArrayList<ArrayList<Integer>> know = new ArrayList<>();
        boolean[] ask = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            know.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            know.get(a).add(b);
        }
        q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            Arrays.fill(ask, false);
            x = scanner.nextInt();
            y = scanner.nextInt();
            Queue<Two> search = new LinkedList<>();
            search.add(new Two(x, 1));
            boolean flag = false;
            while (!search.isEmpty()) {
                int depth = search.peek().depth;
                for (Integer it : know.get(search.poll().num)) {
                    if (it == y) {
                        System.out.println(depth);
                        flag = true;
                        search.clear();
                        break;
                    }
                    if (!ask[it]) {
                        search.add(new Two(it, depth + 1));
                        ask[it] = true;
                    }
                }
            }
            if (!flag) {
                System.out.println(-1);
            }
        }
    }
}
