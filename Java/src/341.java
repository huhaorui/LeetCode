import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer

    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> nums = new ArrayList<>();
    int ptr = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        traverse(nestedList);
    }

    public void traverse(List<NestedInteger> nestedIntegerList) {
        nestedIntegerList.forEach(it -> {
            if (it.isInteger()) {
                nums.add(it.getInteger());
            } else {
                traverse(it.getList());
            }
        });
    }

    @Override
    public Integer next() {
        return nums.get(++ptr);
    }

    @Override
    public boolean hasNext() {
        return ptr < nums.size();
    }
}

/*
  Your NestedIterator object will be instantiated and called as such:
  NestedIterator i = new NestedIterator(nestedList);
  while (i.hasNext()) v[f()] = i.next();
 */