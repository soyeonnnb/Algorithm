import java.util.*;

class Solution {
    public long solution(long n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add((int)(n%10));
            n/=10;
        }
        list.sort((o1, o2) -> o2 - o1);
        long ans = 0;
        for(int num : list) {
            ans *= 10;
            ans += num;
        }
        return ans;
    }
}