import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 16:11
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        boolean[] checked = new boolean[N];
        Arrays.sort(arr);

        int s = N/2-1;
        int e = N-1;
        while(s >= 0) {
            if (checked[e]) {
                e--;
                continue;
            }
            if (s >= e) {
                s = e-1;
            }
            while(s >= 0 && arr[s] * 2 > arr[e]) s--;
            if (s < 0) break;
            checked[s] = true;
            s--;
            e--;
        }
//        System.out.println(Arrays.toString(checked));
        int ans = 0;

        for(int i=0;i<N;i++) if (!checked[i]) ans++;
        System.out.println(ans);
    }
}