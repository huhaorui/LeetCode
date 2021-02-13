import java.util.Arrays;

class Solution_6 {
    public static void main(String[] args) {
        System.out.println(new Solution_6().convert("PAYPALISHIRING", 3));
        System.out.println(new Solution_6().convert("PAYPALISHIRING", 4));
    }

    /*
    0           6           12
    1       5   7       11  13
    2   4       8   10      14
    3           9           15

    0       4       8       12
    1   3   5   7   9   11  13
    2       6       10      14
     */
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int div = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            if (i % div == 0) {
                stringBuilders[0].append(s.charAt(i));
                continue;
            }
            if (i % div == numRows - 1) {
                stringBuilders[numRows - 1].append(s.charAt(i));
                continue;
            }
            stringBuilders[numRows - 1 - Math.abs(i % div - (numRows - 1))].append(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        Arrays.stream(stringBuilders).forEach(stringBuilder -> ans.append(stringBuilder.toString()));
        return ans.toString();
    }
}