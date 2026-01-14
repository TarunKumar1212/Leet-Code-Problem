class Solution {

    public static boolean sumOfDiv(int[] nums , int mid ,int threshold)
    {
        int sum = 0;
        for(int number : nums)
        {
            
            sum += number / mid;
            if(number % mid != 0) sum++;
        }
        if(sum <= threshold) return true;

        return false;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        // if(nums.length > threshold) return -1;

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = -1;

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(sumOfDiv(nums,mid,threshold))
            {
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
    return ans;
    }
}