class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            // Check if adding the next digit will cause overflow or underflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && lastDigit > 7))
                return 0; // Overflow
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && lastDigit < -8))
                return 0; // Underflow
            rev = (rev * 10) + lastDigit;
            x = x / 10;
        }
        return rev;
    }
}
