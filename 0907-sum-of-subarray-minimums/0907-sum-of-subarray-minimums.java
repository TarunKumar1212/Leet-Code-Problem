import java.util.Stack;

class Solution {

    // Method to find Next Smaller Element indices
    public int[] findNse(int arr[], int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // Method to find Previous Smaller Element indices
    public int[] findPse(int arr[], int n) {
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findNse(arr, n);  // next smaller element indices
        int[] pse = findPse(arr, n);  // previous smaller element indices
        long total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];   // number of elements to the left (including i)
            int right = nse[i] - i;  // number of elements to the right (including i)

            total = (total + (long) right * left * arr[i] % mod) % mod;
        }

        return (int) total;
    }
    
    // Method to find Next Greater Element indices
    public int[] findNGe(int arr[], int n) {
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    // Method to find Previous Greater Element indices
    public int[] findPGe(int arr[], int n) {
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }

    public int sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] nge = findNGe(arr, n);  // next greater element indices
        int[] pge = findPGe(arr, n);  // previous greater element indices
        long total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            int left = i - pge[i];   // number of elements to the left (including i)
            int right = nge[i] - i;  // number of elements to the right (including i)

            total = (total + (long) right * left * arr[i] % mod) % mod;
        }

        return (int) total;
    }

    public long subArrayRanges(int[] nums) {
        // Calculate the difference between sum of max subarrays and min subarrays
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }
}
