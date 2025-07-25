public class NthFibbonacciNumber {
    class Solution {
        // using recursive approach
        // Time Complexity: O(2^n)
        public int nthFibonacci1(int n) {
            // code here

            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            return nthFibonacci1(n - 1) + nthFibonacci1(n - 2);
        }

        // using iterative approach
        // Time Complexity: O(n)
        public int nthFibonacci2(int n) {
            // code here

            if (n == 0)
                return 0;
            if (n == 1)
                return 1;

            int mod = 1000000007; // to prevent overflow
            int a = 0;
            int b = 1;
            int fnum = 0;
            for (int i = 2; i <= n; i++) {
                fnum = (a + b) % mod;
                a = b;
                b = fnum;
            }
            return fnum;
        }
    }
    public static void main(String[] args) {
        Solution solution = new NthFibbonacciNumber().new Solution();
        int n = 10; // Example input
        System.out.println("Nth Fibonacci number (recursive): " + solution.nthFibonacci1(n));
        System.out.println("Nth Fibonacci number (iterative): " + solution.nthFibonacci2(n));
    }
}
