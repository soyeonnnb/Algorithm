import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]++;
            arr[Integer.parseInt(st.nextToken())]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) sb.append(arr[i]).append("\n");
        System.out.println(sb);
    }
}