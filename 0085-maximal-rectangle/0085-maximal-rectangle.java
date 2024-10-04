import java.util.Stack;

class Solution {
    
    // Function to calculate the largest rectangle in a histogram
    public int largestRectangleArea(int[] histo) {
        Stack<Integer> st = new Stack<>();
        int maxA = 0;  // Maximum area
        int n = histo.length;
        
        for (int i = 0; i <= n; i++) {
            // While stack is not empty and either reached the end or current height is smaller
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }

    // Function to calculate the maximal rectangle in a binary matrix
    public int maximalRectangle(char[][] matrix) {
        // Check if matrix is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int maxArea = 0;

        // Prefix sum array to store heights of consecutive 1's in each column
        int[][] psum = new int[row][col];

        // Fill the prefix sum array
        for (int j = 0; j < col; j++) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] == '1') {
                    sum += 1;
                } else {
                    sum = 0;
                }
                psum[i][j] = sum;
            }
        }

        // For each row in the prefix sum matrix, find the largest rectangle area
        for (int i = 0; i < row; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(psum[i]));
        }

        return maxArea;
    }
}
