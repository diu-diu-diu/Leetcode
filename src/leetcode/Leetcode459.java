package leetcode;

public class Leetcode459 {
    public  boolean repeatedSubstringPattern(String s) {
        int[] next = preTable(s);
        if(next[s.length()-1] == 0) return false;
        if(s.length() % (s.length() - next[s.length()-1]) == 0) return true;
        return false;
    }
    private int[] preTable(String s){
        int j = 0;
        int[] next = new int[s.length()];
        next[0] = j;
        for(int i = 1; i < s.length(); i++){
            while(j>0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }
}
