public class DayOfTheWeek {
    class Solution {
        static String getDayOfWeek(int d, int m, int y) {
            // Basic date validation
            if (m > 12 || m < 1 || d < 1 || d > 31)
                return "Invalid date";
            if (m == 2 && d > 29)
                return "Invalid date";
            if ((m == 2 && d == 29 && (y % 4 != 0 || (y % 100 == 0 && y % 400 != 0))))
                return "Invalid date";
            if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30)
                return "Invalid date";
            if (y < 1583 || (y == 1582 && (m < 10 || (m == 10 && d < 15))))
                return "Invalid date";
            if (y > 9999)
                return "Invalid date";

            // Adjust month/year for Zeller's algorithm
            if (m == 1) {
                m = 13;
                y--;
            } else if (m == 2) {
                m = 14;
                y--;
            }

            int k = y % 100;
            int j = y / 100;

            int h = (d + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

            switch (h) {
                case 0:
                    return "Saturday";
                case 1:
                    return "Sunday";
                case 2:
                    return "Monday";
                case 3:
                    return "Tuesday";
                case 4:
                    return "Wednesday";
                case 5:
                    return "Thursday";
                case 6:
                    return "Friday";
                default:
                    return "";
            }
        }

    };

    public static void main(String[] args) {
        int d = 15, m = 8, y = 2021; 
        String dayOfWeek = Solution.getDayOfWeek(d, m, y);
        System.out.println("The day of the week is: " + dayOfWeek);
    }
}
