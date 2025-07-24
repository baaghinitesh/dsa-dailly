public class DistanceBetweenTwoPoints {
    class Solution {
        public int distance(int x1, int y1, int x2, int y2) {
            int dx = x2 - x1;
            int dy = y2 - y1;

            
            double d = Math.sqrt(dx * dx + dy * dy);
            return (int) Math.round(d);
        }
    }
}
