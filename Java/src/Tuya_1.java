import java.util.Scanner;

class Tuya_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[n - i - 1] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}