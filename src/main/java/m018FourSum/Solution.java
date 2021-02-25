package m018FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/14
 **/
public class Solution {
    public static void main(String[] args) {

        int[] nums={0,0,0,0};
        List<List<Integer>> lists = fourSum(nums, 0);

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums==null||nums.length<4){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int length = nums.length;

        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for (int i = 0; i < length-3; i++) {

            if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j <length-2 ; j++) {

                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                // 双指针
                int left=j+1;
                int right=length-1;
                while (left<right){


                    int temp=nums[i]+nums[j]+nums[left]+nums[right];
                    if (temp==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while (left<right&&nums[left]==nums[left-1]){
                            left++;
                        }
                        // 这种单边自增，一定要考虑最后数组越界的问题
                        while (right>right&&nums[right]==nums[right+1]){
                            right--;
                        }
                    }
                    else if (temp>target){
                        right--;
                    } else{
                        left++;
                    }
                }

            }

        }
        return ans;
    }
}
