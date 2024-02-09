import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] answer = new int[N];
        int s = 0;
        int e = 0;
        while(s<N && e<N) {
            while(e<N && arr[s] == arr[e]) e++;
            while(e<N && s != e) {
                answer[s] = e;
                s++;
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append(answer[i] == 0 ? -1 : answer[i]+1);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}