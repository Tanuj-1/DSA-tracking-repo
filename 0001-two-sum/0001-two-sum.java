
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

// // 2nd Solution

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int i = 0;
//         int j = nums.length - 1;

//         while (i < j) {
//             int sum = nums[i] + nums[j];

//             if (sum == target) {
//                 return new int[]{i, j};
//             }

//             if (sum < target) {
//                 i++;
//             } else {
//                 j--;
//             }
//         }

//         return new int[]{-1, -1};
//     }
// }
