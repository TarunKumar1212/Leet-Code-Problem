class Solution {

    public static int noOfDays(int[] weights , int capacity)
    {
        int day = 1;
        int load = 0;

        for(int w : weights)
        {
            if((load + w) <= capacity)
            {
                load += w;

            }else{
                day++;
                load = w;
            }
        }
    return day ;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        

        while(low <= high)
        {
            int mid = (low+high)/2;
            if(noOfDays(weights,mid) <= days)
            {
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }

    return low;
    }
}