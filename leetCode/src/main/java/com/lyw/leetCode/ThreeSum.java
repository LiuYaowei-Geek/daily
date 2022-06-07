package com.lyw.leetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    private static List<List<Integer>> threeSum(int[] nums) {
        //sort
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //slip window
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                //find nums[lo] + nums[hi] + nums[i] == 0
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] + nums[i] == 0) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        //skip duplicates
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        //move left pointer and right pointer at same time
                        lo++;
                        hi--;
                        //to make sum equals zero, move left pointer get bigger nums[lo]
                    } else if (nums[lo] + nums[hi] + nums[i] < 0) {
                        lo++;
                        //to make sum equals zero, move right pointer get smaller nums[hi]
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
