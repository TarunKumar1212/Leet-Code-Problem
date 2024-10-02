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
            // Calculate the number of subarrays where arr[i] is the minimum
            int left = i - pse[i];   // number of elements to the left (including i)
            int right = nse[i] - i;  // number of elements to the right (including i)

            // Contribution of arr[i] in all subarrays where it's the minimum
            total = (total + (long) right * left * arr[i] % mod) % mod;
        }

        return (int) total;
    }
}
