import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] count = new int[K];
        int[] arr = new int[60];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[input]++;
        }
        for(int num=1;num<=N;num++) {
            if (arr[num] != 0) {
                count[num % K] += arr[num] - 1;
            } else if (count[num%K] == 0) {
                System.out.println(0);
                return;
            } else {
              count[num%K]--;
            }
        }
        System.out.println(1);
    }
}