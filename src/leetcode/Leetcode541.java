package leetcode;

public class Leetcode541 {
    public static String reverseStr(String s, int k) {
        // 解法1
        /*
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        // 解决 2k > size
        if(2*k > size){
            if(k > size){
                return sb.append(s.substring(0, size)).reverse().toString();
            }
            sb.append(s.substring(0, k)).reverse().append(s.substring(k, size));
            return sb.toString();
        }

        StringBuilder sub = new StringBuilder();
        int charCount = 2 * k;
        while (charCount <= size) {
            //反转前k个,补全k-2k
            sub.append(s.substring(charCount - 2*k, charCount -k)).reverse();
            sb.append(sub).append(s.substring(charCount -k, charCount));
            charCount += 2*k;
            sub.delete(0, sub.length());
        }
        charCount -= 2*k;
        if (size - charCount > 0 && size - charCount < k) {
            //反转剩余全部
            sub.append(s.substring(charCount, size)).reverse();
            sb.append(sub);
        } else if (k <= size - charCount && size - charCount < 2 * k) {
            //反转前k个
            sub.append(s.substring(charCount, charCount + k)).reverse();
            sb.append(sub).append(s.substring(charCount + k, size));
        }

        return sb.toString();
     */
        // 梳理后的代码
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        int start = 0;
        while(start < size){
            StringBuilder sub = new StringBuilder();
            int firstK = (start + k > size)? size : start + k;
            int secondK = (start +2*k > size)? size : start +2*k;
            sub.append(s.substring(start, firstK)).reverse();
            sb.append(sub);
            if(firstK < secondK)  sb.append(s.substring(firstK, secondK));
            start += 2*k;
        }
        return sb.toString();
    }
}