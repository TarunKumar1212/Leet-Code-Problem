import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        List<Integer> ans = new ArrayList<>();
        
        int top = 0 , right = m - 1 , bottom = n - 1, left = 0;
        
        while(left <= right && top <= bottom)
        {
            //left -> right
            for(int i = top ; i <= right ; i++)
            {
                ans.add(matrix[top][i]);
            }
            top++;
            
            //top -> bottom
            
            for(int i = top ; i <= bottom ; i ++)
            {
                ans.add(matrix[i][right]);
            }
            right--;
            
            //right -> left
            if(top <= bottom)
            {
                for(int i =right ; i >= left ; i--)
                {
                ans.add(matrix[bottom][i]);
                }
                bottom--;    
            }
            
            //bottom to top
            
            if(left <= right)
            {
                for(int i = bottom ; i >= top ; i--)
                {
                 ans.add(matrix[i][left]);   
                }
                left++;
            }
            
            
        }
        
        return ans;
    }
}