package e027RemoveElement;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/15
 **/
public class Solution {
    public int removeElement(int[] nums, int val) {

        int j=0;
        for( int i=0;i<nums.length;i++){

            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
