public class PerfectNumber {
    static class Solution {
        static boolean isPerfect(int n) {
            if (n <= 1) return false;

            int sum = 1; 

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    sum += i;

                    int pair = n / i;
                    if (pair != i) {
                        sum += pair;
                    }
                }
            }

            return sum == n;
        }
    }
    public static void main(String[] args) {
        int n = 28; // Example number
        if (Solution.isPerfect(n)) {
            System.out.println(n + " is a perfect number.");
        } else {
            System.out.println(n + " is not a perfect number.");
        }
    }
}
