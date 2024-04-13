import java.util.*;

// 11:00 ~
class Solution {
    private static String[] answer;
    private static boolean flag;
    private static int ticketLength;
    private static Map<String, Integer> map;
    private static List<String>[] list;
    private static boolean[][] visited;
    
    public String[] solution(String[][] tickets) {
        flag = false;
        ticketLength = tickets.length;
        map = new TreeMap<>();
        list = new List[10010];
        for(int i=0;i<10010;i++) list[i] = new ArrayList<>();
        map.put("ICN", 1);
        int N = 1; // 공항수
        for(int i=0;i<tickets.length;i++) {
            int a = map.getOrDefault(tickets[i][0], 0);
            if (a == 0) a = ++N;
            int b = map.getOrDefault(tickets[i][1], 0);
            if (b == 0) b = ++N;
            
            map.put(tickets[i][0], a);
            map.put(tickets[i][1], b);
            // System.out.println(tickets[i][0]+" "+a+"    "+tickets[i][1]+" "+b);
            list[a].add(tickets[i][1]);
        }
        answer = new String[ticketLength + 1];
        for(int i=1;i<=N;i++) list[i].sort(Comparator.naturalOrder());
        // for(int i=1;i<=N;i++) System.out.println(list[i]);
        visited = new boolean[N+1][];
        for(int i=1;i<=N;i++) {
            visited[i] = new boolean[list[i].size()];
        }
        answer[0] = "ICN";
        dfs(1, 1);
        
        return answer;
    }
    private static void dfs(int cur, int idx) {
        if (flag) return;
        if (idx == ticketLength + 1) {
            flag = true;
            return;
        }
        for(int i=0;i<list[cur].size();i++) {
            if (visited[cur][i] || flag) continue;
            answer[idx] = list[cur].get(i);
            // System.out.println(idx+" : "+cur+" -> "+list[cur].get(i));
            visited[cur][i] = true;
            dfs(map.get(list[cur].get(i)), idx+1);
            visited[cur][i] = false;
        }
    }
}