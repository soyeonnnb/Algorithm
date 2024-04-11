import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e){
            return e.cost - this.cost;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i=0;i<=N;i++)parent[i]=i;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int answer = 1000000001;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, c));
        }
        st =new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int connected = 0;
        while(connected < N-1){
            Edge e = pq.poll();
            if (union(e.to, e.from)){
                connected ++;
                answer = Math.min(answer, e.cost);
            }
            if (findset(a) == findset(b)) break;
        }
        System.out.println(answer);
    }
    static int findset(int x){
        if (parent[x] == x) return x;
        else return parent[x] = findset(parent[x]);
    }
    static boolean union(int x, int y){
        int xr = findset(x);
        int yr = findset(y);
        if (xr == yr) return false;
        if (xr < yr) parent[yr] = xr;
        else parent[xr] = yr;
        return true;
    }
}