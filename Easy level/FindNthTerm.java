// Find n-th term of series 1, 3, 6, 10, 15, 21
//This is triangular series


public class FindNthTerm {
    // User function Template for Java

    class Solution {
        static int findNthTerm1(int n) {
            // code here
            int terms = 1;
            int distance = 2;
            for (int i = 1; i < n; i++) {
                terms = terms + distance;
                distance++;
            }
            return terms;
        }

        static int findNthTerm2(int n) {
            // This is triangular series formula
            // Tn = n * (n + 1) / 2
            return (n * (n + 1)) / 2;
        }
    };

    public static void main(String[] args) {
        int n = 5; // Example input
        System.out.println("Nth term using iterative method: " + Solution.findNthTerm1(n));
        System.out.println("Nth term using formula method: " + Solution.findNthTerm2(n));
    }
}
