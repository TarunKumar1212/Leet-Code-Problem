import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                // Handle the collision for negative asteroids
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();  // The positive asteroid is smaller and explodes
                }

                // Either stack is empty or the top is negative
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();  // Both asteroids explode
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);  // No collision, push the negative asteroid
                }
            }
        }

        // Convert stack to an array
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}
