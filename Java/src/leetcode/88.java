package leetcode;

import java.util.Arrays;

class Solution_88 {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        new Solution_88().merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1, ptr2 = n - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] >= nums2[ptr2]) {
                nums1[ptr1 + ptr2 + 1] = nums1[ptr1];
                ptr1--;
            } else {
                nums1[ptr1 + ptr2 + 1] = nums2[ptr2];
                ptr2--;
            }
        }
        if (ptr2 + 1 >= 0) System.arraycopy(nums2, 0, nums1, 0, ptr2 + 1);

    }
}