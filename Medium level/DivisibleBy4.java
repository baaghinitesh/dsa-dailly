// Given a number N. Check whether it is divisble by 4.
// the function divisibleBy4() which takes the number in the form of a string N as input and returns 1 if the number is divisible by 4. Else, it returns 0.

public class DivisibleBy4 {
    public static int divisibleBy4(String N) {
        // Check if the string is empty or null
        if (N == null || N.isEmpty()) {
            return 0; // Not divisible by 4
        }
        
        // Get the last two digits of the number
        String lastTwoDigits = N.length() > 1 ? N.substring(N.length() - 2) : N;
        
        // Convert the last two digits to an integer
        int lastTwoDigitsInt = Integer.parseInt(lastTwoDigits);
        
        // Check if the last two digits are divisible by 4
        return (lastTwoDigitsInt % 4 == 0) ? 1 : 0;
    }
    public static void main(String[] args) {
        // Test cases
        System.out.println(divisibleBy4("123456")); // Output: 0
        System.out.println(divisibleBy4("1234556549848954654897447466581651751564187481561854875418574878518748748187418787678")); // Output: 0
        System.out.println(divisibleBy4("1234")); // Output: 1
        System.out.println(divisibleBy4("4")); // Output: 1
        System.out.println(divisibleBy4("0")); // Output: 1
        System.out.println(divisibleBy4("10000000000000000000000000000000")); // Output: 0
    }
}

