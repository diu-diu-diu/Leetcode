package leetcode;

public class Leetcode151 {
    public String reverseWords(String s) {
        //
        // 倒序
        char[] ori = s.toCharArray();
        char[] res = new char[ori.length + 1];
        int index =  ori.length - 1;
        int resIndex = 0;
        while(index >= 0){
            while(index >= 0 && ori[index] == ' ') index--;  //找第一个非空格索引
            int right = index;
            while(index >= 0 && ori[index] != ' ') index--;  //找空格·
            int left = 1 + index;
            for(int i = left; i <= right; i++){
                res[resIndex++] = ori[i];
                if(i == right) res[resIndex++] = ' ';
            }
        }
        if(resIndex == 0) return null;
        return new String(res, 0, resIndex-1);
    }
}
