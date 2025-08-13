public class nPr {
    public static int calculatenPr1(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    // Iterative approach and more efficient and optimal solution
    static long calculatenPr2(long n, long r) {
        // code here
        long factOfnpr = 1;
        for(long i=n; i>= (n-r+1); i--){
            factOfnpr *= i;
        }
        return factOfnpr;
    }
}
