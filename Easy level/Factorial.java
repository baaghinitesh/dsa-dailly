public class Factorial {
    class Solution {
        static int factorial(int n) {
            // Base case: 0! = 1 and 1! = 1
            if (n == 0 || n == 1) {
                return 1;
            }
            // Recursive case
            return n * factorial(n - 1);
        }
    }
}
