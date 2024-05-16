import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 15:38 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        List<Integer>[] arr = new List[N+1];
        for(int i=1;i<=N;i++) arr[i] = new ArrayList<>();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1) break;
            arr[a].add(b);
            arr[b].add(a);
        }
        int[] score = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        int min = N+1;
        for(int i=1;i<=N;i++) {
            int s = -1;
            queue.add(i);
            Arrays.fill(visited, false);
            visited[i] = true;
            while(!queue.isEmpty()) {
                s++;
                int size= queue.size();
                for(int j=0;j<size;j++) {
                    int now = queue.poll();
                    for(Integer nxt: arr[now]) {
                        if (visited[nxt]) continue;
                        visited[nxt] = true;
                        queue.add(nxt);
                    }
                }
            }
            score[i] = s;
            min = Math.min(min, s);
        }
        StringBuilder sb = new StringBuilder();
        int cnt =0 ;
        for(int i=1;i<=N;i++) {
            if (score[i] == min) {
                cnt++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(min+" "+cnt);
        System.out.println(sb);

    }
}