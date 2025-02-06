import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            int[] arr = new int[N];
            int[] brr = new int[M];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++) brr[i] = Integer.parseInt(br.readLine());

            int a = 0;
            int b = 0;
            int ans = 0;
            while(a < N && b < M) {
                if (arr[a] == brr[b]) {
                    ans++;
                    a++;
                    b++;
                } else if (arr[a] < brr[b]) {
                    a++;
                } else {
                    b++;
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}