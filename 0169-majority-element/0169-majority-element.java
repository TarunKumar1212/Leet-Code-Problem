class Solution {
    public int majorityElement(int[] nums) {
        
        
        int n = nums.length;
        int count = 0 ;
        int elem = 0;
        
        for ( int i =0 ; i < n ; i++)
        {
            if(count == 0)
            {
                count = 1;
                elem = nums[i];
            }
            else if(nums[i] == elem)
            {
                count++;
                
            }
            else{
                count--;
            }
        }
        
        int check = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] == elem) check++;
        }
        
        if(check > n/2){
            return elem;
        }
        
        return -1;
    }
}