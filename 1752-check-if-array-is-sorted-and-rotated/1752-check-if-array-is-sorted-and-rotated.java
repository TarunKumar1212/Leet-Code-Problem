class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        
        // Find the rotation point
        int rotationPoint = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                rotationPoint = i;
                break;
            }
        }
        
        // Check if the array is sorted after rotation
        for (int i = 1; i < n; i++) {
            int index = (rotationPoint + i) % n;
            if (nums[index] < nums[(index - 1 + n) % n]) {
                return false;
            }
        }
        
        return true;
    }
}
