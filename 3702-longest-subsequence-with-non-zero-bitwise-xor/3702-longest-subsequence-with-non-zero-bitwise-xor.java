class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int total_xor = 0;
        int zeros_count= 0;
        for(int i=0;i<n;i++){
            total_xor^=nums[i];
            if(nums[i]==0) zeros_count++;
        }

        if(total_xor!=0)
            return n;

        if(zeros_count == n)
            return 0;

        
        return n-1;
        
    }
}
