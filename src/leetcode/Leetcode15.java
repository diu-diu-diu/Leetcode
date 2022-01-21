package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 双指针法 先排序，在一层循环里用左右指针及i的值确定指针如何移动
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0) return ls;
            if(i > 0 && nums[i-1] == nums[i]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ls.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[right-1] == nums[right]) right--;
                    while(left < right && nums[left + 1] == nums[left]) left++;
                    ++left;
                    --right;
                }
                else if(sum < 0) left++;
                else right--;
            }
        }
        return ls;
    }
}
