import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int N=friends.length;
        Map<String, Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++) {
            map.put(friends[i], i);
        }
        int[] answer = new int[N];
        int[][] presents = new int[N][N];
        StringTokenizer st;
        int[] give = new int[N]; 
        for(String str : gifts) {
            st = new StringTokenizer(str);
            int a = map.get(st.nextToken());
            int b = map.get(st.nextToken());
            presents[a][b]++; // a가 b에게 줌
            give[a]++;
            give[b]--;
        }
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                if (presents[i][j] > presents[j][i]) {
                    answer[i]++;
                } else if (presents[i][j] < presents[j][i]) {
                    answer[j]++;
                } else {
                    if (give[i] == give[j]) continue;
                    else if (give[i] < give[j]) answer[j]++;
                    else answer[i]++;
                }
            
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++) ans = Math.max(ans, answer[i]);
        return ans;
    }
} 