class Solution {
    public int majorityElement(int[] nums) {
        
        int cnt = 0 ;
        int elem = nums[0];
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++)
        {
            if(elem == nums[i])
            {
                cnt++;
            }
            else if( cnt == 0 )
            {
                cnt = 1 ;
                elem = nums[i];
            }
            else{
                cnt--;
            }
        }
        return elem;
    }
}