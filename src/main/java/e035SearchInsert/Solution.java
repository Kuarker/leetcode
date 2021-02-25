package e035SearchInsert;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/15
 **/
public class Solution {
    public int searchInsert(int[] nums, int target) {

        if (nums==null){
            return 0;
        }
        int leng=nums.length;

        for(int i=0;i<leng;i++){

            int temp=nums[i]-target;
            if(temp>=0){
                return i;
            }
        }

        return leng;


    }
}
