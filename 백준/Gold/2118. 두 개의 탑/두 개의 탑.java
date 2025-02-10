import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int total = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        int ans = 0;

        int s = 0;
        int e = 1;
        int sum = arr[0];
        while(s < N) {
            ans = Math.max(ans, Math.min(sum, total - sum));
            if (total - sum < sum) {
                sum -= arr[s];
                s++;
            } else if (total - sum >= sum) {
                sum += arr[e];
                e++;
                if (e >= N) {
                    e = 0;
                }
            }
        }
        System.out.println(ans);
    }
}