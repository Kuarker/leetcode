package e026RemoveDuplicates;

/**
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author: Kuarker Lee
 * @date: 2021/2/15
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        // Arrays.sort(nums);
        for(int j=0; j<nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
