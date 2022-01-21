package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(j > i+1 && nums[j-1] == nums[j]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[i] + nums[j] + nums[left] + nums[right] == target){
                        ls.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    else if(nums[i] + nums[j] + nums[left] + nums[right] < target) left++;
                    else right--;
                }
            }
        }
        return ls;
    }
}
