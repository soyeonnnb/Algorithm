import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[31];
        for(int i=0;i<N;i++) arr[Integer.parseInt(br.readLine())]++;
        int remove = (int) Math.round(N * 0.15);
        double sum = 0;
        for(int i=0;i<=30;i++) {
            sum += arr[i] * i;
        }
        int nowRemove = 0;
        int idx = 1;
        while(nowRemove < remove) {
            if (arr[idx] != 0) {
                sum -= idx;
                arr[idx]--;
                nowRemove++;
            } else {
                idx++;
            }
        }
        nowRemove = 0;
        idx = 30;
        while(nowRemove < remove) {
            if (arr[idx] != 0) {
                sum -= idx;
                arr[idx]--;
                nowRemove++;
            } else {
                idx--;
            }
        }
        double ans = Math.round(sum / (N - 2 * remove));
        System.out.println((int) ans);

    }
}