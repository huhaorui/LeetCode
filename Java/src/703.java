import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> nums;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new PriorityQueue<>();
        Arrays.stream(nums).forEach(num -> {
            this.nums.add(num);
            if (this.nums.size() > k) {
                this.nums.poll();
            }
        });
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }

    public int add(int val) {
        nums.add(val);
        if (nums.size() > k) {
            nums.poll();
        }
        assert !nums.isEmpty();
        return nums.peek();
    }
}

/*
  Your KthLargest object will be instantiated and called as such:
  KthLargest obj = new KthLargest(k, nums);
  int param_1 = obj.add(val);
 */