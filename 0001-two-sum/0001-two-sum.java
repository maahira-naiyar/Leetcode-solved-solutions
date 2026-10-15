



// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     return new int[]{i, j};
//                 }
//             }
//         }
//         return new int[]{}; // No solution found
//     }
// }
// import java.util.Arrays;

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
// Integer[] index = new Integer[nums.length];
//         int[] sorted = Arrays.copyOf(nums, nums.length);
//         Arrays.sort(sorted);

        
        
//  for (int i = 0; i < nums.length; i++) {
//             index[i] = i;
//         }
//         int i = 0;
//         int j = sorted.length - 1;
//         while (i < j) {
//             if (sorted[i] + sorted[j] == target) {
//                 int first= nums[index[i]] ;
//                 int second = nums[index[i]];
//                 return new int[]{index[i], index[j]};
//               //  return new int[]{sorted[i], sorted[j]};
//             }
//             else if (sorted[i] + sorted[j] < target) {
//                 i++;
//             }
//             else {
//                 j--;
//             }
//         }

//         return new int[]{};
//     }
// }


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                return new int[]{i, indexMap.get(complement)};
            }
            indexMap.put(nums[i], i);
        }

        return new int[]{};
    }
}