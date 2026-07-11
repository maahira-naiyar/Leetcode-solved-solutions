// class Solution {
//     public int maxDigitRange(int[] nums) {
//         int ans = 0, mx = 0;
//         for (int x : nums) {
//             int a = 10, b = 0;
//             for (int y = x; y > 0; y /= 10) {
//                 int v = y % 10;
//                 a = Math.min(a, v);
//                 b = Math.max(b, v);
//             }
//             int r = b - a;
//             if (mx < r) {
//                 mx = r;
//                 ans = x;
//             } else if (mx == r) {
//                 ans += x;
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        int sum = 0;

        for (int num : nums) {
            int original = num;
            int max = 0;
            int min = 9;

            while (num > 0) {
                int digit = num % 10;
                max = Math.max(max, digit);
                min = Math.min(min, digit);
                num /= 10;
            }

            int range = max - min;

            if (range > maxRange) {
                maxRange = range;
                sum = original;
            } else if (range == maxRange) {
                sum += original;
            }
        }

        return sum;
    }
}