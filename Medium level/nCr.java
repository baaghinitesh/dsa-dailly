import java.math.BigInteger;

public class nCr {
    public int calculateNCR(int n, int r) {
        // code here
        if(r<0 || r>n) return 0;
        r = Math.min(r, n-r);
        BigInteger res = BigInteger.ONE;
        for(int i = 1; i <= r; i++){
            res = res.multiply(BigInteger.valueOf(n - r + i))
                     .divide(BigInteger.valueOf(i));  
        }
        return res.intValue();
    }
    public static void main(String[] args) {
        nCr ncr = new nCr();
        System.out.println(ncr.calculateNCR(5, 2)); // Output: 10
        System.out.println(ncr.calculateNCR(10, 3)); // Output: 120
        System.out.println(ncr.calculateNCR(0, 0)); // Output: 1
        System.out.println(ncr.calculateNCR(5, 6)); // Output: 0
    }
}
