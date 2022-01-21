package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(mp.containsKey(c))  mp.put(c, mp.get(c) + 1);
            else mp.put(c, 1);
        }
        for(int i = 0; i < magazine.length(); i++){
            char d = magazine.charAt(i);
            if(mp.containsKey(d)) {
                if(mp.get(d) > 0) mp.put(d, mp.get(d) - 1);
                else mp.remove(d);
            }
        }
        for(int z : mp.values()){
            if(z > 0) return false;
        }
        return true;
    }
}
