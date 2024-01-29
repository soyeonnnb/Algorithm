import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+2];
        arr[0] = -1000000000;
        arr[N+1] = 1000000000;
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        boolean checked = false;
        for(int i=1;i<=N;i++) {
            if (arr[i-1] > arr[i]) {
                if (checked) {
                    System.out.println(0);
                    return;
                }
                checked = true;
                // i-1을 없애는 경우
                if (arr[i-2] <= arr[i] && arr[i] <= arr[i+1]) answer++;
                // i를 없애는 경우
                if (arr[i-1] <= arr[i+1] && (i == N || arr[i+1] <= arr[i+2])) answer++;
            }
        }
        System.out.println(checked ? answer : N);
    }
}