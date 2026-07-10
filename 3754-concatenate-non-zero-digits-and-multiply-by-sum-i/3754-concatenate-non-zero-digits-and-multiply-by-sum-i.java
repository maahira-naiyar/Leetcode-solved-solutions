class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        long x = 0;
        long digitSum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0) {
                digitSum += digit;
                x = x * 10 + digit;
            }
        }
        return x * digitSum;
    }
}
