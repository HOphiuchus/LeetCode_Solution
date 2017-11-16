package main;

public class LC004MediaOfTwoSortedArrays {
    //Todo
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int t = nums.length;

        int k = 0;
        for (int i = 0, j = 0; i < m || j < n; ) {
            if (i == m) {
                nums[k++] = nums2[j++];
                continue;
            }
            if (j == n) {
                nums[k++] = nums1[i++];
                continue;
            }

            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        if ((t & 1) == 1) {
            return nums[t / 2];
        } else {
            return ((nums[t / 2 - 1] + nums[t / 2]) / 2.0);
        }
    }
}
