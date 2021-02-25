package m011MaxArea;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/5
 **/
public class Solution {

    public static void main(String[] args) {
        int[] ints = {4, 1, 1, 1, 4, 4};
        System.out.println(maxArea(ints));
    }

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length;
        int area = 0;
        while (left <( right - 1)) {
            int high = Math.min(height[left], height[right - 1]);
            area = Math.max(area, high * (right - left-1));

            if (height[left] <= height[right - 1]) {
                left++;
            }else {
                right--;
            }
        }
        return area;
    }
}
