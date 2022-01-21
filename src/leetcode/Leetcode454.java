package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int rescount = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = nums1[i] + nums2[j];
                if(mp.containsKey(sum)){
                    int z = mp.get(sum);
                    mp.put(sum, ++z);
                }
                else mp.put(sum, 1);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
               int value = -nums3[i] - nums4[j];
               if(mp.containsKey(value)) rescount += mp.get(value);
            }
        }
        return rescount;
    }
}
