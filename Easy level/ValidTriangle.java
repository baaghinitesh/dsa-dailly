public class ValidTriangle {
    class Solution {
        public boolean checkValidity(int a, int b, int c) {
            // code here
            return (a + b > c) && (b + c > a) && (c + a > b);
        }
    }
}
