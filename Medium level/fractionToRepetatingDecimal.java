import java.util.HashMap;
import java.util.Map;

public class fractionToRepetatingDecimal {
    public String calculateFraction(int a, int b) {
        if (a == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        if (a < 0 ^ b < 0)
            result.append("-");
        long numerator = Math.abs((long) a);
        long denominator = Math.abs((long) b);
        long intPart = numerator / denominator;
        result.append(intPart);
        long remainder = numerator % denominator;
        if (remainder == 0)
            return result.toString();
        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();
        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            remainderMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / denominator);
            remainder %= denominator;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        fractionToRepetatingDecimal fraction = new fractionToRepetatingDecimal();
        System.out.println(fraction.calculateFraction(1, 3));  // Output: 0.(3)
        System.out.println(fraction.calculateFraction(2, 1));  // Output: 2
        System.out.println(fraction.calculateFraction(4, 333));  // Output: 0.(012)
        
    }
}
