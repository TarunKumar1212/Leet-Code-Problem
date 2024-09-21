class Solution {
    public  static void rev(int[] nums , int st , int end)
    {
        while(st < end)
        {
            swap(nums,st,end);
            st++;
            end--;
                
        }
        
    }
    
    public  static void swap(int[] nums , int st , int end)
    {
        int temp = nums[st];
        nums[st] = nums[end];
        nums[end] = temp ;
    }
    
    public void nextPermutation(int[] nums) {
        
        int breakPoint = -1 ;
        int n = nums.length;
        
        
        for(int i = n -2 ; i >= 0 ; i--)
        {
            if(nums[i] < nums[i + 1]) 
            {
                breakPoint = i;
                break;
            }
        }
        
        if(breakPoint  == -1)
        {
            rev(nums, 0 , n-1);
            return;
        }
        for(int i = n -1 ; i >= breakPoint ; i--)
        {
            if(nums[i] > nums[breakPoint])
            {
                swap(nums,i,breakPoint);
                break;
                
            }
        }
        
        rev(nums,breakPoint+1,n-1);
    }
}