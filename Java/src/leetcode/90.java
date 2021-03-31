package leetcode;

import java.util.*;
import java.util.stream.Collectors;

class Solution_90 {
    Set<List<Integer>> ans = new HashSet<>();

    public void search(List<Integer> numsFrom, List<Integer> numsTo) {
        if (numsFrom.isEmpty()) {
            ans.add(numsTo.stream().sorted().collect(Collectors.toList()));
            return;
        }
        Integer num = numsFrom.get(0);
        List<Integer> newNumsFrom = new ArrayList<>(numsFrom);
        newNumsFrom.remove(num);
        search(newNumsFrom, numsTo);
        List<Integer> newNumsTo = new ArrayList<>(numsTo);
        newNumsTo.add(num);
        search(newNumsFrom, newNumsTo);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> n = Arrays.stream(nums).boxed().collect(Collectors.toList());
        search(n, new ArrayList<>());
        return new ArrayList<>(ans);
    }
}