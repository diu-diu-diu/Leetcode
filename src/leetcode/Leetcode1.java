package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {
    public static int[] twoSum(int[] nums, int target) {
        //非暴力解法
        int[] res = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(mp.containsKey(temp)){
                res[0] = i;
                res[1] = mp.get(temp);
            }
            mp.put(nums[i], i);
        }
        return res;
    }
}
