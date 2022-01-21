package leetcode;

public class Leetcode28_KMP {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int[] next = preTable(needle);
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = next[j-1];
                }
            if(haystack.charAt(i) == needle.charAt(j)) j++;
            if(j == needle.length()) return i - j + 1;
            }
        return -1;
    }
    private int[] preTable(String n){
        int[] next = new int[n.length() + 1];
        int j = 0;
        next[0] = j;
        for(int i = 1; i < n.length(); i++){
            //不匹配，回退
            while(j >= 1 && n.charAt(i) != n.charAt(j)){
                j = next[j-1];  //找j前一个元素在next数组里的值
            }
            if(n.charAt(i) == n.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
