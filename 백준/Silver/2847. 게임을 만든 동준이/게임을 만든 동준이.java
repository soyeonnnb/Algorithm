import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12:29 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        int answer = 0;
        int before = arr[N-1];
        for(int i=N-2;i>=0;i--) {
            if (arr[i] >= before) {
                answer += arr[i] - before + 1;
                before--;
            } else {
                before = arr[i];
            }
        }
        System.out.println(answer);
    }
}