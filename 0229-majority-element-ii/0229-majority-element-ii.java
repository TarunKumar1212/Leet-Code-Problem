class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ls = new ArrayList<>();
        

        int n = nums.length;
        int cnt1 = 0 ;
        int cnt2 = 0 ;
        
        int elem1 = Integer.MIN_VALUE;
        int elem2 = Integer.MIN_VALUE;
            
        
        for(int i = 0 ; i < n ; i++)
        {
            if(cnt1 == 0 && elem2 != nums[i])
            {
                cnt1 = 1;
                elem1 = nums[i];
            }
            else if(cnt2 == 0 && elem1 != nums[i])
            {
                cnt2 = 1 ;
                elem2 = nums[i];
            }
            else if(elem1 == nums[i]) cnt1++;
            else if(elem2 == nums[i]) cnt2++;
            
            else{
                cnt1--;
                cnt2--;
            }
            
           
            
        
        
        }
        
         //manula check
             cnt1 = 0 ; 
             cnt2 = 0 ;
        
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] == elem1) cnt1++;
            if(nums[i] == elem2) cnt2++;
        }

        
        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(elem1);
        if (cnt2 >= mini) ls.add(elem2); 
        
        return ls;
    }
}