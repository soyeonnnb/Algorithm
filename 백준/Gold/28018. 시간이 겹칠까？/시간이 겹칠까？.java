import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19:39 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[1000010];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]++;
            arr[Integer.parseInt(st.nextToken())+1]--;
        }
        for(int i=1;i<=1000000;i++) arr[i] += arr[i-1];
        StringBuilder sb = new StringBuilder();
        int Q=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int q=0;q<Q;q++) {
            int time = Integer.parseInt(st.nextToken());
            sb.append(arr[time]+"\n");
        }
        System.out.println(sb);
    }
}