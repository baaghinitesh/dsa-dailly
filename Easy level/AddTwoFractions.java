public class AddTwoFractions {
    /* You are required to complete this function */
    static class GfG {
        void addFraction(int num1, int den1, int num2, int den2) {
            // Your code here
            int num3;
            int den3;

            num3 = num1 * den2 + num2 * den1;
            den3 = den1 * den2;
            int a = num3;
            int b = den3;
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            num3 = num3 / a;
            den3 = den3 / a;
            System.out.println(num3 + "/" + den3);
        }
    }

    public static void main(String[] args) {
        GfG gfg = new GfG();
        gfg.addFraction(1, 2, 1, 3); // Example fractions
    }
}
