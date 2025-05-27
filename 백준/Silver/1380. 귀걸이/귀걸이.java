
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = 1;
        outer: while(true) {
            int N=Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            String[] str = new String[N+1];
            for(int i=1;i<=N;i++) str[i] = br.readLine();
            int[] checked = new int[N+1];
            for(int i=0;i<N*2 - 1;i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                checked[n] ++;
            }
            for(int i=1;i<=N;i++) {
                if (checked[i] != 2) {
                    sb.append(tc).append(" ").append(str[i]).append("\n");
                    tc++;
                    continue outer;
                }
            }
        }
        System.out.println(sb);
    }
}
