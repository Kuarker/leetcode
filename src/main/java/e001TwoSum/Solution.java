package e001TwoSum;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/2
 **/
class Solution {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 4, 5, 7, 8};
        int target = 9;
        Solution solution = new Solution();
        int[] twoSum = solution.twoSum(ints, target);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;

    }
}