// 16:43 ~
import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        long answer = slide(-1, sequence);
        answer = Math.max(answer, slide(1, sequence));
        
        return answer;
    }
    
    private static long slide(int idx, int[] sequence) {
        int N=sequence.length;
        long[] pulse = new long[N+1];
        for(int i=0;i<N;i++) {
            pulse[i+1] = sequence[i] * idx;
            idx *= -1;
        }
        // System.out.println(Arrays.toString(pulse));
        long ans = 0;
        long sum = 0;
        int s = 0;
        int e = 0;
        while(s <= N && e <= N) {
            // System.out.println(s+" "+e+" "+sum);
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum -= pulse[s];
                s++;
            } else {
                e++;
                if (e <= N)
                    sum += pulse[e];
            }
        }
        return ans;
    }
}