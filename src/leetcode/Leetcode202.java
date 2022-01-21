package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
    public int sqrsum(int n){
        int sum = 0;
        while(n > 0){
            int num = n % 10;
            sum += num*num;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> intset = new HashSet<>();
        int sum = sqrsum(n);
        while(sum != 1){
            if(intset.contains(sum)) return false;
            else intset.add(sum);
            sum = sqrsum(sum);
        }
        return true;
    }
}
