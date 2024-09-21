public class Solution {
    public static void rev(int[] nums, int st, int end) {
        while (st < end) {
            swap(nums, st, end);
            st++;
            end--;
        }
    }

    public static void swap(int[] nums, int st, int end) {
        int temp = nums[st];
        nums[st] = nums[end];
        nums[end] = temp;
    }

    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
        int n = nums.length;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // Step 2: If no breakpoint is found, reverse the entire array
        if (breakPoint == -1) {
            rev(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the smallest element larger than nums[breakPoint] from the right
        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                swap(nums, i, breakPoint);
                break;
            }
        }

        // Step 4: Reverse the part of the array after the break point
        rev(nums, breakPoint + 1, n - 1);
    }

//     public static void main(String[] args) {
//         int[] arr = {1, 3, 2};
//         Solution solution = new Solution();
//         solution.nextPermutation(arr);

//         // Print the next permutation
//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//     }
}
