package leetcode;

class Solution_1491 {
    public double average(int[] salary) {
        int sum = 0, max = salary[0], min = salary[0], count = salary.length - 2;
        for (int i : salary) {
            sum += i;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return (double) (sum - max - min) / count;
    }
}