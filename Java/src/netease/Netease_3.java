package netease;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * WA 80%
 */
public class Netease_3 {
    static int min = Integer.MAX_VALUE;

    static void search(List<Integer> nums, int now, int mod) {
        if (now % 6 == mod) {
            min = Math.min(now, min);
            return;
        }
        if (now > min) {
            return;
        }
        List<Integer> newList = new ArrayList<>(nums);
        for (int i = 0; i < newList.size(); i++) {
            Integer tmp = newList.get(i);
            newList.remove(tmp);
            search(newList, now + tmp, mod);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int sum = 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int tmp = scanner.nextInt();
            sum += tmp;
            nums.add(tmp);
        }
        if (sum % 6 == 0) {
            System.out.println(sum);
            return;
        }
        if (length <= 1) {
            System.out.println(-1);
            return;
        }
        nums.sort(Comparator.comparingInt(n -> n));
        int mod = sum % 6, now = 0;
        search(nums, now, mod);
        if (sum==min) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum - min);
    }
}
