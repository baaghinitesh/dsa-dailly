// You are given a list of q queries, and for each query, an integer n is provided. The task is to find how many numbers less than or equal to n have exactly 3 divisors.

// Examples:

// Input: q = 1
//           query[0] = 6
// Output: 1
// Explanation: There is only one number 4 which has exactly three divisors 1, 2 and 4 and less than equal to 6.
// Input: q = 2
//        query[0] = 6
//        query[1] = 10
// Output: 1
//         2
// Explanation: For query 1 it is covered in the example 1. query 2:There are two numbers 4 and 9 having exactly 3 divisors and less than 
// equal to 10.

import java.util.*;
import java.io.*;

class Solution {
    // Moved outside threeDivisors and made static
    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // For All Queries (total q queries):
    // Total time = O(q × √n × √n) = O(q × n)
    // Space Complexity: O(q)
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q) {
        ArrayList<Integer> output = new ArrayList<>();

        // For each query
        for (int i = 0; i < q; i++) {
            long n = query.get(i);
            int count = 0;

            for (int p = 2; (long) p * p <= n; p++) {
                if (isPrime(p)) {
                    count++;
                }
            }

            output.add(count);
        }

        return output;
    }
}

//a more efficient version of your threeDivisors algorithm using the Sieve of Eratosthenes and binary search.
// Precompute all primes ≤ √(max(n)) using Sieve.

// Precompute all valid p² values (i.e. squares of those primes).

// For each query, count how many p² values are ≤ n using binary search (upper_bound logic).

// Time and Space Complexity:
// Preprocessing Time: O(√maxN * log log √maxN) for sieve.

// Query Time: O(q × log k) where k is the number of valid p² values.

// Space: O(√maxN) for storing primes.
class Solution2 {
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q) {
        ArrayList<Integer> output = new ArrayList<>();

        // Step 1: Find max value in query to set sieve limit
        long max = Collections.max(query); // Use 'long' here, not int
        int limit = (int) Math.sqrt(max) + 1; // Typo fixed: 'squrt' → 'sqrt'

        // Step 2: Sieve of Eratosthenes to find primes up to √(max)
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Generate all p^2 where p is prime
        ArrayList<Long> threeDivNum = new ArrayList<>(); 
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                long square = (long) i * i;
                threeDivNum.add(square);
            }
        }

        // Step 4: Process each query using binary search
        for (long n : query) {
            int count = upperBound(threeDivNum, n);
            output.add(count);
        }

        return output;
    }

    // Binary search: count how many numbers ≤ value
    static int upperBound(ArrayList<Long> list, long value) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= value) {
                low = mid + 1; // FIXED: use mid+1, not low+1
            } else {
                high = mid;
            }
        }

        return low;
    }
}

public class ThreeDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Prompting user for input
        System.out.println("Enter number of queries:");
        int q = Integer.parseInt(br.readLine().trim());

        ArrayList<Long> query = new ArrayList<>();
        System.out.println("Enter " + q + " query values (each on a new line):");

        for (int i = 0; i < q; i++) {
            query.add(Long.parseLong(br.readLine().trim()));
        }

        // Run Solution 1 (Brute-force with isPrime check)
        System.out.println("\n--- Output from Solution 1 (Brute-force isPrime) ---");
        ArrayList<Integer> result1 = Solution.threeDivisors(query, q);
        for (int res : result1) {
            System.out.println(res);
        }

        // Run Solution 2 (Efficient using Sieve and Binary Search)
        System.out.println("\n--- Output from Solution 2 (Sieve + Binary Search) ---");
        ArrayList<Integer> result2 = Solution2.threeDivisors(query, q);
        for (int res : result2) {
            System.out.println(res);
        }

        br.close();
    }
}
// The code above implements two solutions to find how many numbers less than or
// equal to n have exactly 3 divisors.
// The first solution uses a brute-force approach with a prime-checking
// function, while the second
// solution uses the Sieve of Eratosthenes to find prime numbers and then
// calculates the squares of those primes.  