public class DecToBinary {
    class Solution {
        static String decToBinary(int n) {
            // code here
            if (n == 0)
                return "0";
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                sb.append(n % 2);
                n = n / 2;
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        String binaryRepresentation = DecToBinary.Solution.decToBinary(n);
        System.out.println("Binary representation of " + n + " is: " + binaryRepresentation);
    }
}
