import java.util.ArrayList;
import java.util.LinkedList;

class MyHashSet {
    ArrayList<LinkedList<Integer>> nums;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        nums = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            nums.add(new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(123);
        myHashSet.remove(123);
    }

    public void add(int key) {
        nums.get(key % 10000).add(key);
    }

    public void remove(int key) {
        nums.get(key % 10000).removeIf(it -> it == key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return nums.get(key % 10000).contains(key);
    }
}

/*
  Your MyHashSet object will be instantiated and called as such:
  MyHashSet obj = new MyHashSet();
  obj.add(key);
  obj.remove(key);
  boolean param_3 = obj.contains(key);
 */