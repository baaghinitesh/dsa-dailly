// Binary Search-based Square Root Algorithm

// Algorithm Steps:
// Input: A non-negative integer x.
// Edge Cases:
// If x == 0 or x == 1, return x.
// Initialize:
// start = 1, end = x
// Variable ans = 0 to store the result
// Binary Search Loop:
// While start <= end:
// Compute mid = (start + end) / 2
// If mid * mid == x, return mid (perfect square)
// If mid * mid < x:
// Set ans = mid (because it's a valid candidate)
// Move right: start = mid + 1
// Else:
// Move left: end = mid - 1
// Return ans, which is the floor of the square root.

public class SquareRoot {
    class Solution {
        // Function to find the floor of the square root of a number.
        int floorSqrt(int n) {
            // code here
            if (n == 0 || n == 1) {
                return n;
            }
            int start = 1, end = n, ans = 0;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (mid == (n / mid)) {
                    return mid;
                } else if (mid < (n / mid)) {
                    ans = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return ans;
        }

        // Function to find the square root of a number upto decimal places.
        double sqrt(int n, int p) {

            double ans = floorSqrt(n);
            double increment = 0.1;

            for (int i = 0; i < p; i++) {
                while (ans * ans <= n) {
                    ans += increment;
                }
                ans -= increment;
                increment /= 10;
            }
            return ans;
        }

        // Function to compute square root using Newton-Raphson method
        public static double newtonSqrt(int x, int precision) {
            if (x == 0 || x == 1)
                return x;

            double guess = x; // initial guess
            double epsilon = Math.pow(10, -precision); // acceptable error margin

            while (Math.abs(guess * guess - x) > epsilon) {
                guess = (guess + x / guess) / 2.0;
            }

            return guess;
        }

    }

    public static void main(String[] args) {
        Solution solution = new SquareRoot().new Solution();
        System.out.println("Floor of square root of 16: " + solution.floorSqrt(16)); // 4
        System.out.println("Square root of 20 up to 2 decimal places: " + solution.sqrt(20, 2)); // 4.47
        System.out.println("Square root of 25 using Newton-Raphson: " + Solution.newtonSqrt(25, 2)); // 5.0
    }
}
