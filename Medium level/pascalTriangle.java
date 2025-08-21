public class pascalTriangle {
    public static void main(String[] args) {
        int n = 10; // Number of rows for Pascal's Triangle
        System.out.println("Pascal's Triangle with " + n + " rows:");
        printPascalTriangle(n);
    }
    
    public static void printPascalTriangle(int n) {
        int[][] pascal = new int[n][n];
        
        // Fill the Pascal's Triangle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                }
            }
        }
        
        // Find the maximum number to determine spacing
        int maxNum = pascal[n-1][(n-1)/2]; // Middle element of last row
        int maxWidth = String.valueOf(maxNum).length();
        
        // Print the Pascal's Triangle with proper formatting
        for (int i = 0; i < n; i++) {
            // Calculate spaces for center alignment
            int totalSpaces = (n - i - 1) * (maxWidth + 1);
            
            // Add spaces for proper triangle alignment
            for (int space = 0; space < totalSpaces; space++) {
                System.out.print(" ");
            }
            
            // Print the numbers in the current row
            for (int j = 0; j <= i; j++) {
                // Format each number with consistent width
                String numStr = String.valueOf(pascal[i][j]);
                int padding = maxWidth - numStr.length();
                
                // Add padding spaces before the number
                for (int p = 0; p < padding; p++) {
                    System.out.print(" ");
                }
                
                System.out.print(pascal[i][j]);
                
                // Add space between numbers (except for the last number in the row)
                if (j < i) {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Move to next line after each row
        }
    }
}
