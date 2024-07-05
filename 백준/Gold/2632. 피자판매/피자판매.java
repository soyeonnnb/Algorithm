import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pizza = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        for(int i=0;i<N;i++) arr1[i] = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        for(int i=0;i<M;i++) arr2[i] = Integer.parseInt(br.readLine());

        int[] prefix1 = new int[pizza+1];
        int[] prefix2 = new int[pizza+1];

        for(int i=0;i<N;i++) {
            int now = arr1[i];
            int j=i;
            while(now <= pizza) {
                prefix1[now]++;
                j++;
                if (j >= N) {
                    j=0;
                }
                if (i == j) break;
                if ((i > j && i == j+1) || (i == 0 && j == N-1)) break;
                now += arr1[j];
            }
        }
        for(int i=0;i<M;i++) {
            int now = arr2[i];
            int j=i;
            while(now <= pizza) {
                prefix2[now]++;
                j++;
                if (j >= M) {
                    j=0;
                }
                if (i == j) break;
                if ((i > j && i == j+1) || (i == 0 && j == M-1)) break;
                now += arr2[j];
            }
        }
        int sum = 0;
        for(int i=0;i<N;i++) sum += arr1[i];
        if (sum <= pizza) prefix1[sum]++;

        sum = 0;
        for(int i=0;i<M;i++) sum += arr2[i];
        if (sum <= pizza) prefix2[sum]++;

        long ans = 0;
        prefix1[0] = 1;
        prefix2[0] = 1;
        for(int i=0;i<=pizza;i++) ans += (long) prefix1[i] * prefix2[pizza-i];
        System.out.println(ans);

    }
}