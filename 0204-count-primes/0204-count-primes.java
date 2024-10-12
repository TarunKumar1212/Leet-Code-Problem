class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;  // There are no primes less than 2
        }

        // Create an array to mark prime numbers
        int[] prime = new int[n];

        // Mark all numbers as potential primes initially
        for (int i = 2; i < n; i++) {
            prime[i] = 1;
        }

        // Sieve of Eratosthenes to mark non-prime numbers
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = 0;  // Mark multiples of i as non-prime
                }
            }
        }

        // Count the number of primes less than n
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i] == 1) {
                cnt++;
            }
        }

        return cnt;
    }
}
