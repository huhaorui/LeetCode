package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            nums.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        search(nums, ans, new ArrayList<>());
        ans.forEach(System.out::println);
    }

    static void search(List<Integer> nums, List<List<Integer>> ans, List<Integer> now) {
        if (nums.size() != 0) {
            for (int i = 0; i < nums.size(); i++) {
                int toMove = nums.get(i);
                List<Integer> newList = nums.stream().filter(it -> !it.equals(toMove)).collect(Collectors.toList());
                List<Integer> newNow = new ArrayList<>(now);
                newNow.add(toMove);
                search(newList, ans, newNow);
            }
        } else {
            ans.add(now);
        }
    }
}
