// This is the manual long division method, where:
// You bring down one digit at a time
// Build a new number with the current remainder
// Subtract the highest possible multiple of the divisor (13)
// Carry the remainder forward
// Final Time Complexity:
// O(n) — where n is the number of digits in the input string.
// Space Complexity: O(1) — no additional space used except for a few variables

public class DivisibleBy13 {
    public boolean divby13(String s) {
        int remainder = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            remainder = remainder * 10 + digit;

            if (remainder < 13)
                continue;

            for (int j = 0; 13 * j <= remainder; j++) {
                if (13 * (j + 1) > remainder) {
                    remainder = remainder - 13 * j;
                    break;
                }
            }
        }
        return remainder == 0;
    }

    public static void main(String[] args) {
        DivisibleBy13 obj = new DivisibleBy13();
        System.out.println(obj.divby13("1234567890123")); // Example test case
        System.out.println(obj.divby13("130")); // Should return true
        System.out.println(obj.divby13("131")); // Should return false
    }
}
