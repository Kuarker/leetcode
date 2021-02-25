package h004FindMedianSortedArrays;

/**
 * @description:
 * @author: Kuarker Lee
 * @date: 2021/2/3
 **/
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{5, 6, 7, 8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 递归调整顺序
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int totalMid = (l1 + l2 + 1) / 2;
        int left = 0;
        int right = l1;
        // left 和 right 表示查找的区间，条件nums1[i] < nums2[j-1]成立与否，也只不断缩小区间而已
        while (left < right) {
            // 二分查找的的中间值
            int i = left + (right - left) / 2;
            int j = totalMid - i;

            // 有序的，nums1[i-1]<nums1[i] < nums2[j-1]<nums[j],所以nums1[i-1]必然小于nums[j]
            // 这个条件是为了不断缩小区间
            if (nums1[i] < nums2[j - 1]) {
                // 下一个搜索区间[i+1 ,right]
                left = i + 1;
            } else {
                // 下一个搜索区间 [left, i]
                right = i;
            }
        }
        int i = left;
        int j = totalMid - i;
        int nums1_left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1_right = i == l1 ? Integer.MAX_VALUE : nums1[i];
        int nums2_left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2_right = j == l2 ? Integer.MAX_VALUE : nums2[j];

        int leftMax = Math.max(nums1_left, nums2_left);
        int rightMin = Math.min(nums1_right, nums2_right);

        boolean totalIsOdd = ((l1 + l2) % 2) == 1;
        if (totalIsOdd) {
            return leftMax / 1.0;
        } else {
            return (leftMax + rightMin) / 2.0;
        }
    }


}
