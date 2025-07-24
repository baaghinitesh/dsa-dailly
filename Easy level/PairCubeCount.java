// Given a positive integer n, count all pairs of ‘a’(>=1) and ‘b’(>=0) that satisfy the condition a3 + b3 = n.

public class PairCubeCount {
    // User function Template for Java

    class Solution {
        static int pairCubeCount(int n) {
            // code here
            int count = 0;

            for (int i = 1; i * i * i <= n; i++) {
                for (int j = 0; j * j * j <= n; j++) {
                    if (n == i * i * i + j * j * j) {
                        count = count + 1;
                    }
                }
            }
            return count;
        }
    };
}
