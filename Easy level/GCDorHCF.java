import java.util.ArrayList;

public class GCDorHCF {

    // Solution 1: Euclidean Algorithm
    static class Solution1 {
        public static int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }

    // Solution 2: Factorization Method
    static class Solution2 {
        public static int gcd(int a, int b) {
            ArrayList<Integer> factorsA = new ArrayList<>();
            ArrayList<Integer> factorsB = new ArrayList<>();

            // Get divisors of a
            for (int i = 1; i <= a; i++) {
                if (a % i == 0)
                    factorsA.add(i);
            }

            // Get divisors of b
            for (int i = 1; i <= b; i++) {
                if (b % i == 0)
                    factorsB.add(i);
            }

            // Find largest common divisor
            int gcd = 1;
            for (int i : factorsA) {
                if (factorsB.contains(i)) {
                    gcd = Math.max(gcd, i);
                }
            }
            return gcd;
        }
    }

    public static void main(String[] args) {
        int a = 56, b = 98;

        System.out.println("Using Euclidean Algorithm:");
        System.out.println("GCD of " + a + " and " + b + " is: " + Solution1.gcd(a, b));

        System.out.println("\nUsing Factorization Method:");
        System.out.println("GCD of " + a + " and " + b + " is: " + Solution2.gcd(a, b));
    }
}
