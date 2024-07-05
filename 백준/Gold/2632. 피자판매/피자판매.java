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

        int[] prefix1 = sum(N, pizza, arr1);
        int[] prefix2 = sum(M, pizza, arr2);

        long ans = 0;
        for(int i=0;i<=pizza;i++) ans += (long) prefix1[i] * prefix2[pizza-i];
        System.out.println(ans);

    }

    private static int[] sum(final int SIZE, final int PIZZA, int[] arr) {
        int[] prefix = new int[PIZZA+1];
        
        prefix[0] = 1;

        for(int i=0;i<SIZE;i++) {
            int now = arr[i];
            int j=i;
            while(now <= PIZZA) {
                prefix[now]++;
                j++;
                if (j >= SIZE) {
                    j=0;
                }
                if (i == j) break;
                if ((i > j && i == j+1) || (i == 0 && j == SIZE-1)) break;
                now += arr[j];
            }
        }

        int sum = 0;
        for(int i=0;i<SIZE;i++) sum += arr[i];
        if (sum <= PIZZA) prefix[sum]++;

        return prefix;
    }

}