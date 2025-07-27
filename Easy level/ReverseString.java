public class ReverseString {
    class Solution {
        // Function to reverse a string
        public String reverse(String str) {
            char[] chars = toCharArray(str);
            int left = 0, right = chars.length - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            return new String(chars);
        }

        public static char[] toCharArray(String str){

            char[] arr = new char[str.length()];
            for(int i=0; i<str.length();i++){
                arr[i] = str.charAt(i);
            }
            return arr;
        } 
    }

    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        String str = "Hello, World!"; // Example input
        System.out.println("Reversed string: " + solution.reverse(str));
    }
}
