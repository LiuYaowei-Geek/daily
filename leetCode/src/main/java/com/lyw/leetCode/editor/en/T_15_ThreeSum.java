//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 17427 👎 1673


package com.lyw.leetCode.editor.en;

import java.util.*;

//Java：T_15_3Sum
public class T_15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new T_15_ThreeSum().new Solution();
        // TO TEST
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        System.out.println(solution.threeSum1(nums));
        System.out.println(solution.threeSum2(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //暴力循环，时间复杂度O(n^3)，空间复杂度O(1)
        public List<List<Integer>> threeSum1(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            //先排序，为了后面判断，避免相同的数字计算两边，导致结果重复
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                //每层第一次循环的初始值需要进行计算
                //每层后续(非第一次)循环，不能重复计算相同的值
                //if判断不能写在for循环里，不然当false时，会直接返回到上层，本层不会再循环
                if ((i == 0 || nums[i] != nums[i - 1]) && nums[i] <= 0) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (j == i + 1 || nums[j] != nums[j - 1]) {
                            for (int k = j + 1; k < nums.length; k++) {
                                if ((k == j + 1 || nums[k] != nums[k - 1]) && nums[k] >= 0) {
                                    if (nums[i] + nums[j] + nums[k] == 0) {
                                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }

        //双指针，优化三层嵌套循环，减少为两层循环
        //时间复杂度O(n^2)
        //空间复杂度：O(log N)O(logN)。我们忽略存储答案的空间，额外的排序的空间复杂度为 O(log N)O(logN)。然而我们修改了输入的数组nums，在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了 nums 的副本并进行排序，空间复杂度为 O(N)。
        //先排序，在双层遍历，内层用双指针分别指向头尾进行判断
        public List<List<Integer>> threeSum2(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            //先排序，为了后面判断，避免相同的数字计算两边，导致结果重复
            Arrays.sort(nums);
            for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                int target = -nums[i];
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        res.add(Arrays.asList(-target, nums[low], nums[high]));
                        //仅在相等时做nums[low] == nums[low + 1]的判断，目的是为了返回结果去重
                        //low指针移动到和当前数字相同的最后一个数
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        //继续移动Low指针，使得nums[low+1] != nums[low]
                        //相等时，low和high都要移动
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < target) {
                        //这里不用判断nums[low+1] == nums[low]，因为做这个判断和循环的判断两个必做其中一个，所有没必要
                        low++;
                    } else {
                        high--;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}