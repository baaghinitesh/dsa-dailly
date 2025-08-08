import java.math.BigInteger;

public class PrintThekthDigit {
    static long kthDigit(int a, int b, int k) {
        // code here
        BigInteger base = BigInteger.valueOf(a);
        BigInteger result = base.pow(b);
        String sresult = result.toString();
        int rlength = sresult.length();
        // kth digit from right means (length-k) for 0 based indexing

        if (k > rlength || k <= 0) {
            return 0;
        }
        char ch = sresult.charAt(rlength - k);
        return Character.getNumericValue(ch);
    }
    public static void main(String[] args) {
        System.out.println(kthDigit(2, 3, 1)); // Should return 8 (2^3 = 8)
        System.out.println(kthDigit(5, 2, 1)); // Should return 5 (5^2 = 25)
        System.out.println(kthDigit(10, 3, 2)); // Should return 0 (10^3 = 1000)
        System.out.println(kthDigit(15, 15, 13)); // Should return 3 (15^15 = 437893890380859375)
    }
}
