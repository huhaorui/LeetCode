package tuya;

import java.util.Scanner;

class Tuya_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] time = new int[128];
        for (int i = 0; i < input.length(); i++) {
            time[input.charAt(i)]++;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            if (time[i] != 0) {
                out.append((char) i).append("=").append(time[i]).append(" ");
            }
        }
        System.out.println(out.deleteCharAt(out.length() - 1).toString());
    }
}