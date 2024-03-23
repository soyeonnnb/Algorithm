import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14:13 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());
        int[] arr = new int[100010];
        for(int i=0;i<N;i++) {
            int K=Integer.parseInt(br.readLine());
            for(int j=0;j<K;j++) {
                st = new StringTokenizer(br.readLine());;
                arr[Integer.parseInt(st.nextToken())]++;
                arr[Integer.parseInt(st.nextToken())]--;
            }
        };
        for(int i=1;i<=100000;i++) arr[i] += arr[i-1]; // 일단 다 합치기

        for(int i=1;i<=100000;i++) arr[i] += arr[i-1]; // 누적합
        int s = 1;
        int e = T;
        int[] answer = new int[]{0, T, arr[T-1]};
        while(e <= 100000) {
            if (arr[e] - arr[s-1] > answer[2]) {
                answer[0] = s;
                answer[1] = e+1;
                answer[2] = arr[e] - arr[s-1];
            }
            s++;
            e++;
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}