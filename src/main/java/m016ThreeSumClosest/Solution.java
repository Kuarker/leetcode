package m016ThreeSumClosest;

import java.util.Arrays;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/11
 **/
public class Solution {

    public static void main(String[] args) {
        int[] ints={1,2,3,4,5,1,0,1};
        int i = threeSumClosest(ints, 4);
        System.out.println(i);
    }
    public static int threeSumClosest(int[] nums, int target) {
        // 先排序
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        ;
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            int diff1 = Math.abs(target - sum);
            while (left < right) {

                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) {
                    return target;
                }
                if (temp > target) {
                    right--;
                }
                if (temp < target) {
                    left++;
                }
                int diff2 = Math.abs(target - temp);
                if (diff2 <diff1) {
                    diff1 = diff2;
                    sum = temp;
                }
            }


        }
        return sum;

    }
}
