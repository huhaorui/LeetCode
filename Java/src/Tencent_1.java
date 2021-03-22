import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ListNodeTencent1 {
    int val;
    ListNodeTencent1 next = null;

    public ListNodeTencent1(int val) {
        this.val = val;
    }
}


class TreeNodeTencent1 {
    int val;
    TreeNodeTencent1 left = null;
    TreeNodeTencent1 right = null;

    public TreeNodeTencent1(int val) {
        this.val = val;
    }
}

class SolutionTencent_1 {
    public static void main(String[] args) {
        TreeNodeTencent1 root = new TreeNodeTencent1(1);
        root.left = new TreeNodeTencent1(2);
        root.right = new TreeNodeTencent1(3);
        root.left.left = new TreeNodeTencent1(4);
        root.left.right = new TreeNodeTencent1(5);
        root.right.left = new TreeNodeTencent1(6);
        root.right.right = new TreeNodeTencent1(7);
        int[] nums = new int[]{1, 2, 3, 5, 6, 7};
        System.out.println(Arrays.toString(new SolutionTencent_1().solve(root, nums)));

    }


    public void traverse(TreeNodeTencent1 node, String way, Map<Integer, String> ways) {
        if (node != null) {
            ways.put(node.val, way);
            if (node.left != null) {
                traverse(node.left, way + "L", ways);
            }
            if (node.right != null) {
                traverse(node.right, way + "R", ways);
            }
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 你需要返回m个指针，第i个指针指向一条链，表示第i个问题的答案
     *
     * @param root TreeNodeTencent1类 指向链表树的根
     * @param b    int整型一维数组 表示每个问题是什么
     * @return ListNode类一维数组
     */
    public ListNodeTencent1[] solve(TreeNodeTencent1 root, int[] b) {
        ListNodeTencent1[] anss = new ListNodeTencent1[b.length];
        Map<Integer, String> ways = new HashMap<>();
        traverse(root, "", ways);
        for (int i = 0; i < b.length; i++) {
            String path = ways.get(b[i]);
            TreeNodeTencent1 now = root;
            ListNodeTencent1 ans = new ListNodeTencent1(0);
            ListNodeTencent1 nowList = ans;
            for (int j = 0; j < path.length(); j++) {
                nowList.next = new ListNodeTencent1(0);
                nowList = nowList.next;
            }
            nowList = ans;
            nowList.val = root.val;
            nowList = nowList.next;
            for (int j = 0; j < path.length(); j++) {
                if (path.charAt(j) == 'L') {
                    now = now.left;
                } else {
                    now = now.right;
                }
                nowList.val = now.val;
                nowList = nowList.next;
            }
            anss[i] = ans;
        }
        return anss;
    }
}