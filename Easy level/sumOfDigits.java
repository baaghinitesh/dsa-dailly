public class SumOfDigits {

    // Method to calculate sum of digits
    static int sumOfDigits(int n) {
        int num = n;
        int last;
        int sum = 0;
        while (num != 0) {
            last = num % 10;   // Get last digit
            sum = sum + last;  // Add to sum
            num = num / 10;    // Remove last digit
        }
        return sum;
    }

    public static void main(String[] args) {
        int number = 12345;  // Example number
        int result = sumOfDigits(number);
        System.out.println("Sum of digits of " + number + " is: " + result);
    }
}
