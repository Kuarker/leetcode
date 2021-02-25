package m015ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/11
 **/
public class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 2, -2};
        List<List<Integer>> lists = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[0] > 0) {
                return lists;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                int temp = nums[left] + nums[right];
                if (temp == target) {
                    lists.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 左先自增，右也自增
                    left++;
                    right--;
                    // 判断是否和左边元素相等，若相等，继续自增
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (temp < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return lists;
    }
}
