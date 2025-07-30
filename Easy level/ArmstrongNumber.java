public class ArmstrongNumber {
    // User function Template for Java
    static class Solution {
        // Function to check if a three digit number is an Armstrong number or not.
        static boolean armstrongNumberForThreeDigits(int n) {
            // Ensure it's a 3-digit number
            if (n < 100 || n > 999) {
                return false;
            }
            int num = n;
            int armNumber = 0;

            while (num != 0) {
                int digit = num % 10;
                armNumber += digit * digit * digit;
                num /= 10;
            }

            return armNumber == n;
        }

        // Function to check if any-digit number is an Armstrong number
        static boolean generalArmstrongNumber(int n) {
            int num = n;
            int digits = 0;
            int sum = 0;

            // Count digits
            while (num != 0) {
                digits++;
                num /= 10;
            }
            if (digits == 0) digits = 1; // For n = 0

            num = n;
            while (num != 0) {
                int digit = num % 10;
                sum += (int)Math.pow(digit, digits);
                num /= 10;
            }
            if (n == 0) sum = 0; // For n = 0

            return sum == n;
        }
    }

    public static void main(String[] args) {
        System.out.println("153 is 3-digit Armstrong: " + Solution.armstrongNumberForThreeDigits(153));  // true
        System.out.println("1634 is 3-digit Armstrong: " + Solution.armstrongNumberForThreeDigits(1634)); // false
        System.out.println("1634 is general Armstrong: " + Solution.generalArmstrongNumber(1634));        // true
    }
}
