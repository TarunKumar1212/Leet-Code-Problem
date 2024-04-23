class Solution {
    
    public static int max(int max1,int cnt){
        if(max1 > cnt) {
            return max1;
        }
        return  cnt;
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int cnt = 0;
        int max1 = 0;
        int n = nums.length;
        
        for(int i = 0 ;i<n;i++){
            if(nums[i] == 1 ){
                cnt ++;
                max1 = max(max1,cnt);
            }
            else{
                cnt = 0;
            }
            
        }
        return max1;
    }
}