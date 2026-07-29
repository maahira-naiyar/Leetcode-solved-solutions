class Solution {
 

    private static final long MAX = 1_000_001L;
 
    public String smallestPalindrome(String s, long k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
 
        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 == 1) oddCount++;
        }
        if (oddCount > 1) return "";
 
        int[] half = new int[26];
        char mid = '\0';
        boolean hasMid = false;
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if (freq[i] % 2 == 1) {
                mid = (char) ('a' + i);
                hasMid = true;
            }
        }
 
        long total = countArrangements(half);
        if (k > total) return "";
 
        int halfLen = 0;
        for (int f : half) halfLen += f;
 
        StringBuilder left = new StringBuilder();
        for (int pos = 0; pos < halfLen; pos++) {
            for (int i = 0; i < 26; i++) {
                if (half[i] == 0) continue;
                half[i]--;
                long arrangements = countArrangements(half);
                if (arrangements >= k) {
                    left.append((char) ('a' + i));
                    break;
                } else {
                    k -= arrangements;
                    half[i]++;
                }
            }
        }
 
        StringBuilder result = new StringBuilder();
        result.append(left);
        if (hasMid) result.append(mid);
        result.append(left.reverse());
        return result.toString();
    }
 

    private long countArrangements(int[] count) {
        int total = 0;
        for (int c : count) total += c;
 
        long res = 1;
        for (int f : count) {
            res *= nCk(total, f);
            if (res >= MAX) return MAX;
            total -= f;
        }
        return res;
    }

    private long nCk(int n, int r) {
        r = Math.min(r, n - r);
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res >= MAX) return MAX;
        }
        return res;
    }
}