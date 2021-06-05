package com.example.reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举a
        for (int first = 0; first < n; first++) {
            // 跳过和上一次重复的数字
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            // c对应的指针指向数组的最右端
            int third = n-1;
            int target = -nums[first];
            // 枚举b
            for (int second = first + 1; second < n; second ++){
                // 跳过和上一次重复的数字
                if (second > first+1 && nums[second] == nums[second-1]) {
                    continue;
                }
                // 如果b和c的值大于目标值，则左移c的指针（需要保证b的指针在c的指针的左侧）
                while (second < third && nums[second] + nums[third] > target){
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加，就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third){
                    break;
                }

                // 如果b+c=-a，则说明找到符合要求的三元组，加入结果列表中
                if (nums[second] + nums[third] == target){
                    List<Integer> triple = new ArrayList<>();
                    triple.add(nums[first]);
                    triple.add(nums[second]);
                    triple.add(nums[third]);
                    ans.add(triple);
                }
            }
        }
        return ans;
    }
}
