import java.util.HashMap;
import java.util.Map;

class Pair<T1, T2> {
    T1 first;
    T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }
}

class LRUCache {
    Map<Integer, Pair<Integer, Integer>> cache = new HashMap<>();
    int capacity, time;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    public int get(int key) {
        time++;
        Pair<Integer, Integer> value = cache.get(key);
        if (value != null) {
            value.setSecond(time);
            return value.getFirst();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        time++;
        cache.remove(key);
        cache.put(key, new Pair<>(value, time));
        if (cache.size() > capacity) {
            var ref = new Object() {
                Integer min = null;
            };
            cache.forEach((k, v) -> {
                if (ref.min == null) {
                    ref.min = k;
                }
                if (v.getSecond() < cache.get(ref.min).getSecond()) {
                    ref.min = k;
                }
            });
            cache.remove(ref.min);
        }
    }
}

/*
  Your LRUCache object will be instantiated and called as such:
  LRUCache obj = new LRUCache(capacity);
  int param_1 = obj.get(key);
  obj.put(key,value);
 */