public class ReverseTheDigit {
    // User function Template for Java

    class Solution {
        public int reverseDigits(int n) {
            // Code here
            int num = n;
            int revNum = 0;
            int last;
            while (num != 0) {
                last = num % 10;
                num = num / 10;
                revNum = revNum * 10 + last;
            }
            return revNum;
        }
    }
}
