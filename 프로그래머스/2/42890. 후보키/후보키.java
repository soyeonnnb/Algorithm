import java.util.*;

class Solution {
    private static int answer, N, M;
    private static boolean[] checked;
    private static StringBuilder sb = new StringBuilder();
    private static List<boolean[]> list = new ArrayList<>();
    public int solution(String[][] relation) {
        answer = 0;
        N=relation[0].length; // 컬럼 수
        M=relation.length; // 로우 수
        checked = new boolean[N];
        for(int i=1;i<=N;i++) { // 선택할 개수
            recur(0, i, 0, relation);
        }
        
        return answer;
    }
    
    
    
    private static void recur(int now, int flag, int count, String[][] relation) { // 이제 선택해야 하는 거, 목표 개수, 개수
        if (flag == count) {
            // 선택한 것들이 유일성을 만족하는지 확인
            Set<String> set = new HashSet<>();
            for(int j=0;j<M;j++) {
                sb = new StringBuilder();
                for(int i=0;i<N;i++) {
                    if (!checked[i]) continue;
                    sb.append(relation[j][i]).append("_");
                }
                String str = sb.toString();
                if (set.contains(str)) return;
                set.add(str);
            }
            
            for(boolean[] li : list) {
                int c = 0;
                int total = 0;
                for(int i=0;i<N;i++) {
                    if (!li[i]) continue;
                    total++;
                    if (checked[i]) c++;
                }
                if (c == total) return;
            }
            
            
            boolean[] newArr = new boolean[N];
            for(int i=0;i<N;i++) newArr[i] = checked[i];
            
            list.add(newArr);
            answer++;
            return;
        }
        if (now >= N) return;
        
        // 선택 X
        recur(now+1, flag, count, relation);
                
        // 선택
        checked[now] = true;
        recur(now+1, flag, count+1, relation);
        checked[now] = false;
        
        
    }
}