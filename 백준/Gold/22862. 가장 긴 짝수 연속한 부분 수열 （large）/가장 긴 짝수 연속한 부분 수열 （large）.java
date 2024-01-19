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
        boolean[] arr =new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken())%2 == 1;
        }
        int s = 0;
        int e = 0;
        int answer = 0;
        int remove = arr[0] == true ? 1 : 0;
        while(e<N) {
            if (remove <= K) {
                answer = Math.max(answer, e-s+1-remove);
            }
            if (remove <= K) {
                e++;
                if (e<N && arr[e]) remove++;
            } else if (remove > K) {
                if (arr[s]) remove--;
                s++;
            }
        }
        if (remove <= K) {
            answer = Math.max(answer, e-s-remove);
        }
        System.out.println(answer);
    }
}