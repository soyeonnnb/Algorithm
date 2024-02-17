import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, min, max;
    private static int[] arr, cal, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        cal = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) cal[i] = Integer.parseInt(st.nextToken());
        min = 2000000000;
        max = -2000000000;
        recur(0);
        System.out.println(max+"\n"+min);

    }
    private static void recur(int cur) {
        if (cur == N-1) {
            int result = arr[0];
            for(int i=0;i<N-1;i++) {
                switch (answer[i]) {
                    case 0:
                        result += arr[i+1];
                        break;
                    case 1:
                        result -= arr[i+1];
                        break;
                    case 2:
                        result *= arr[i+1];
                        break;
                    case 3:
                        result /= arr[i+1];
                        break;
                }
            }
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for(int i=0;i<4;i++) {
            if (cal[i] == 0) continue;
            answer[cur] = i;
            cal[i]--;
            recur(cur+1);
            cal[i]++;
        }
    }

}