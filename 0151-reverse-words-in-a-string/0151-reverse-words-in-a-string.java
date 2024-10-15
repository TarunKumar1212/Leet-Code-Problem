class Solution {
    public String reverseWords(String s) {
        
        
        s = s.trim();
        // Trim leading and trailing spaces and split by one or more spaces
        String[] as = s.split("\\s+");
        
        int n = as.length;
        int fst = 0 ;
        int last = n - 1 ;
        
        while(fst < last)
        {
            String temp = as[fst];
            as[fst] = as[last];
            as[last] = temp ;
            
            fst++;
            last--;
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < n ; i++)
        {
            ans.append(as[i]);
            if(i < n-1) ans.append(" ");
        }
        
        
         return ans.toString();
        
    }
}