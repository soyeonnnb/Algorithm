import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] prefix = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 2) {
            System.out.println(Math.max(arr[0], arr[1]));
            return;
        }
        prefix[0] = arr[0];
        prefix[1] = arr[1];
        for(int i=2;i<N;i++) {
            prefix[i] = prefix[i-2] + arr[i];
        }
//        System.out.println(Arrays.toString(prefix));
        int answer = Math.max(prefix[N-1], prefix[N-2]);
        for(int i=1;i<N;i++) { // i 번째 나누어줄 때 밑장뺸거였으면
            int sum = 0;
            if (i%2 == 1) { // 만약 상대방 차례 때 밑장뺀거면
                if (i==1) {
                    sum = prefix[i-1] + prefix[N-3];
                }else {
                    sum = prefix[i-1] + prefix[N-3] - prefix[i-2];
                }
            } else { // 만약 내 차례 때 밑장뺀거면
                sum = prefix[i-2] + prefix[N-1] - prefix[i-1];
            }
//            System.out.println(i+" "+sum);
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}