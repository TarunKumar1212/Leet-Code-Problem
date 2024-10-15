class Solution {
    public void reverseString(char[] s) {
       
        int n = s.length;
        
        int frst = 0 ;
        int last = n - 1 ;
        
        while( frst <= last)
        {
            char temp = s[frst];
            s[frst] = s[last];
            s[last] = temp;
            
            frst++;
            last--;
        }
        
        
    }
}