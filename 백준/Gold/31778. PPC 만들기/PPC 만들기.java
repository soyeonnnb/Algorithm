import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int s=0;
        int e=N-1;
        int remainCount=0;
        while(s<e &&remainCount<K) {
            if (arr[s] == 'P') s++;
            else if (arr[e] == 'C') e--;
            else {
                arr[s++] = 'P';
                arr[e--] = 'C';
                remainCount++;
            }
        }
        int[] pPrefix = new int[N];
        if (arr[0] == 'P') pPrefix[0]++;
        for(int i=1;i<N;i++) {
            if (arr[i] == 'P') pPrefix[i]++;
            pPrefix[i] += pPrefix[i-1];
        }
        long ans = 0;
        for(int i=1;i<N;i++) {
            if (arr[i] == 'P') continue;
            if (pPrefix[i-1] < 2) continue;
            long res = (long) pPrefix[i-1] * (pPrefix[i-1] -1) / 2;
            ans+=res;
        }
        System.out.println(ans);
    }
}