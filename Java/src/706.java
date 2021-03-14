class MyHashMap {
    Integer[] nums = new Integer[1000005];

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        nums[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (nums[key] != null) {
            return nums[key];
        } else {
            return -1;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        nums[key] = null;
    }
}

/*
  Your MyHashMap object will be instantiated and called as such:
  MyHashMap obj = new MyHashMap();
  obj.put(key,value);
  int param_2 = obj.get(key);
  obj.remove(key);
 */