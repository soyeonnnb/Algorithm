import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + k + 1];
        int[] count = new int[d+1];
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            if (i <= k) {
                arr[i+N] = num;
            }
        }

        int s = 0;
        int e = 0;
        int point = 0;
        while(e < k) {
            count[arr[e]]++;
            if (count[arr[e]] == 1) {
                point++;
            }
            e++;
        }
        int ans = point + (count[c] == 0 ? 1 : 0);

        while(e < N + k) {
            count[arr[s]]--;
            if (count[arr[s++]] == 0) point--;
            count[arr[e]]++;
            if (count[arr[e++]] == 1) point++;
            ans = Math.max(ans, point + (count[c] == 0 ? 1 : 0));
        }

        System.out.println(ans);
    }
}