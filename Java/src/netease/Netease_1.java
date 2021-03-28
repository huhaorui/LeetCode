package netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * AC
 */
public class Netease_1 {
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int toGet = scanner.nextInt();
        if (input.equals("[]")) {
            System.out.println("[]");
            return;
        }
        List<Integer> nums = Arrays.stream(input.split(","))
                .map(it -> it.replace("[", "")
                        .replace("]", "")
                        .replace("null", "100000")
                )
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> path = new ArrayList<>();
        path.add(nums.get(0));
        search(nums, 0, nums.get(0), toGet, path);
        if (ans.size() == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < ans.size() - 1; i++) {
            System.out.print(ans.get(i) + ",");
        }
        System.out.print(ans.get(ans.size() - 1));
        System.out.println("]");
    }

    static void search(List<Integer> nums, int position, int sum, int toGet, List<Integer> path) {
        if (toGet == sum && (path.size() < ans.size() || ans.size() == 0)) {
            ans = new ArrayList<>(path);
        }
        if (nums.size() > position * 2 + 1) {
            List<Integer> newPath1 = new ArrayList<>(path);
            newPath1.add(nums.get(position * 2 + 1));
            search(nums, position * 2 + 1, sum + nums.get(position * 2 + 1), toGet, newPath1);
        }
        if (nums.size() > position * 2 + 2) {
            List<Integer> newPath2 = new ArrayList<>(path);
            newPath2.add(nums.get(position * 2 + 2));
            search(nums, position * 2 + 2, sum + nums.get(position * 2 + 2), toGet, newPath2);
        }
    }
}
