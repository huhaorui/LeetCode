package leetcode;

class Solution_978 {
    public static void main(String[] args) {
        int[] array = {0, 0, 0};
        Solution_978 solution = new Solution_978();
        System.out.println(solution.maxTurbulenceSize(array));
    }

    public int maxTurbulenceSize(int[] arr) {
        int length = arr.length;
        if (length == 1) return 1;
        if (length == 2) {
            if (arr[0] != arr[1])
                return 2;
            else
                return 1;
        }
        int n = arr[0];
        boolean flag = false;
        for (int j : arr) {
            if (j != n) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return 1;
        int leftPtr = 0, rightPtr = 2;
        int maxLength = 2;
        while (rightPtr < length) {
            int gap1 = arr[rightPtr] - arr[rightPtr - 1];
            int gap2 = arr[rightPtr - 1] - arr[rightPtr - 2];
            if ((gap1 ^ gap2) >= 0 || gap1 == 0 || gap2 == 0) {
                maxLength = Math.max(rightPtr - leftPtr, maxLength);
                leftPtr = rightPtr - 1;
            }
            rightPtr++;
        }
        rightPtr = length - 1;
        int gap1 = arr[rightPtr] - arr[rightPtr - 1];
        int gap2 = arr[rightPtr - 1] - arr[rightPtr - 2];
        if ((gap1 ^ gap2) >= 0 || gap1 == 0 || gap2 == 0) {
            return maxLength;
        } else
            return Math.max(maxLength, rightPtr - leftPtr + 1);
    }
}