
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N=Integer.parseInt(br.readLine());
        Integer M=Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[200_010];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[Integer.parseInt(st.nextToken())] = true;
        }
        if (M >= 200000) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for(int i=0;i<=M/2;i++) {
            if (arr[i] && arr[M-i]) count++;
        }
        if (M%2 == 0 && arr[M/2]) count--;
        System.out.println(count);
     }
}
