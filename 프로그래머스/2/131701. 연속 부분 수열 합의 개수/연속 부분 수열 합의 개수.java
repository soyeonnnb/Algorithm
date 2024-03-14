import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new TreeSet<>();
        int N=elements.length;
        // 0 ~ 해당 인덱스까지의 합
        int[] prefix = new int[N+1];
        for(int i=1;i<=N;i++) prefix[i]  = elements[i-1] + prefix[i-1];
        for(int size=1;size <= N;size ++) {
            int s = 0; // s 이후부터
            int e = size; // e까지를 더함
            while(s != N) {
                if (s < e) {
                    set.add(prefix[e] - prefix[s]);
                } else { // s > e
                    set.add(prefix[N] - prefix[s] + prefix[e]);
                }
                s++;
                e = (e+1)%N;
                
            }
        }
        
        return set.size();
    }
}