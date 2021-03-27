package netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * WA 50%
 */
public class Netease_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            nums.add(scanner.nextInt());
        }
        if (length < 5) {
            System.out.println(0);
            return;
        }
        int leftPtr = 0, rightPtr = 4;
        int ans = 0;
        while (rightPtr < length) {
            while (rightPtr < length && isYb(nums, leftPtr, rightPtr)) {
                rightPtr++;
                ans = Math.max(ans, rightPtr - leftPtr);
            }
            leftPtr++;
            rightPtr = leftPtr + Math.max(4, ans);
        }
        System.out.println(ans);
    }

    static boolean isYb(List<Integer> nums, int left, int right) {
        int addCount = 0, downCount = 0, continuousAdd = 0, continuousDown = 0;
        for (int i = left; i < right; i++) {
            if (nums.get(i + 1).equals(nums.get(i))) {
                return false;
            } else if (nums.get(i + 1) > nums.get(i)) {
                addCount++;
                continuousAdd++;
                if (continuousDown == 1 && i > 2) {
                    return false;
                }
                if (continuousAdd > 2) {
                    return false;
                }
                continuousDown = 0;
            } else {
                downCount++;
                continuousDown++;
                if (continuousAdd == 1 && i > 2) {
                    return false;
                }
                if (continuousDown > 2) {
                    return false;
                }
                continuousAdd = 0;
            }
        }
        return addCount >= 2 && downCount >= 2;
    }
}
