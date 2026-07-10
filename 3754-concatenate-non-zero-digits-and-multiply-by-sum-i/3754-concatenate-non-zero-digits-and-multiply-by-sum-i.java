class Solution {
    public long sumAndMultiply(int n) {
        int[] digits = new int[10];
        int count = 0;
        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;

            if (digit != 0) {
                digits[count++] = digit;
                sum += digit;
            }

            temp /= 10;
        }

        if (count == 0)
            return 0;

        long x = 0;

        for (int i = count - 1; i >= 0; i--) {
            x = x * 10 + digits[i];
        }

        return x * sum;
    }
}