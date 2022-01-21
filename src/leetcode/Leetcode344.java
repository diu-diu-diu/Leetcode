package leetcode;

public class Leetcode344 {
    public void reverseString(char[] s) {
        int size = s.length;
        if(size <= 1) return ;
        int left = 0;
        int right = size;
        while(left < right){
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
        return;
    }
}
