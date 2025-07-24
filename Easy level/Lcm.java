public class Lcm {
    //using the Euclidean algorithm to find LCM
    //LCM(a, b) = (a * b) / GCD(a, b)

    class Solution {
    public int lcm(int a, int b) {
        // code here
        int a1 = a;
        int b1 = b;
        
        while(b1!=0){
            int temp = b1;
            b1 = a1%b1;
            a1 = temp;
        }
        return (a*b)/a1;
    }

    //using the prime factorization method to find LCM
    public int lcmPrimeFactorization(int a, int b) {
        int lcm = 1;
        int i = 2;

        while (a > 1 || b > 1) {
            if (a % i == 0 || b % i == 0) {
                lcm *= i;
                if (a % i == 0) a /= i;
                if (b % i == 0) b /= i;
            } else {
                i++;
            }
        }
        return lcm;
    }
}

    public static void main(String[] args) {
        int a = 15, b = 20;
        Solution solution = new Lcm().new Solution();
        System.out.println("LCM of " + a + " and " + b + " is: " + solution.lcm(a, b));
        System.out.println("LCM of " + a + " and " + b + " using prime factorization is: " + solution.lcmPrimeFactorization(a, b));
    }
}
