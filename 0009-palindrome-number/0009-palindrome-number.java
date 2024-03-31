class Solution {
    public boolean isPalindrome(int x) {
        
        int org = x;
        int rev = 0;
        
        if(x<0){
            return false;
        }
        
        while(x>0){
            
            int lastD = x % 10 ;
            
            rev = (rev * 10 ) + lastD;
            
            x = x / 10;
        }
        
        if(org == rev){
            return true;
        }else{
            return false;
        }
        
    }
}