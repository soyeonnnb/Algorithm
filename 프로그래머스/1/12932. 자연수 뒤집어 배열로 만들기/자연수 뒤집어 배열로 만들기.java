import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add((int)(n%10));
            n/=10;
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++) ans[i] = list.get(i);
        return ans;
    }
}