class Solution {
    public long getSum(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long res = 0;

        int[] d1 = new int[n];
        int left = 0, right = -1;

        for (int i = 0; i < n; i++) {
            int k = (i > right) ? 1 : Math.min(d1[left + right - i], right - i + 1);

            while (i - k >= 0 && i + k < n && nums[i - k] == nums[i + k]) {
                k++;
            }

            d1[i] = k;

            int l = i - k + 1;
            int r = i + k - 1;
            res = Math.max(res, prefix[r + 1] - prefix[l]);

            if (r > right) {
                left = l;
                right = r;
            }
        }

        int[] d2 = new int[n];
        left = 0;
        right = -1;

        for (int i = 0; i < n; i++) {
            int k = (i > right) ? 0 : Math.min(d2[left + right - i + 1], right - i + 1);
            while (i - k - 1 >= 0 && i + k < n && nums[i - k - 1] == nums[i + k]) {
                k++;
            }

            d2[i] = k;

            if (k > 0) {
                int l = i - k;
                int r = i + k - 1;
                res = Math.max(res, prefix[r + 1] - prefix[l]);
            }

            if (i + k - 1 > right) {
                left = i - k;
                right = i + k - 1;
            }
        }

        return res;
    }
}