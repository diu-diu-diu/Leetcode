package leetcode;

public class Offer58_2 {
    public String reverseLeftWords(String s, int n) {
        // 调子字符串方法申请了额外空间
        //反转区间为前n的子串
        //反转区间为n到末尾的子串
        //反转整个字符串
        StringBuffer result = new StringBuffer(s);
        reverse(result, 0, n-1);
        reverse(result, n, s.length()-1);
        reverse(result, 0, s.length()-1);
        return result.toString();
    }
    private void reverse(StringBuffer res, int start, int end){
        while(start < end){
            char c = res.charAt(start);
            res.setCharAt(start, res.charAt(end));
            res.setCharAt(end, c);
            start++;
            end--;
        }
    }
}
