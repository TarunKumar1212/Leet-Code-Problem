class Solution {

    // Function to reverse a part of the array
    public static void rev(int[] nums, int start, int end) {
        while (start < end) {
            // Swap the elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        
        // Ensure k is within bounds of the array length
        k = k % n;
        
        // If k is zero, there's no need to rotate
        if (k == 0) {
            return;
        }

        // Step 1: Reverse the entire array
        rev(nums, 0, n - 1);
        
        // Step 2: Reverse the first k elements
        rev(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining elements from k to n-1
        rev(nums, k, n - 1);
    }
}
