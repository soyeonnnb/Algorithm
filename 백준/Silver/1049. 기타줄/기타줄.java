import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[]{1001, 1001};
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) arr[j] = Math.min(arr[j], Integer.parseInt(st.nextToken()));
        }
        if (arr[0] > arr[1] * 6) {
            System.out.println(arr[1] * N);
        } else {
            System.out.println(Math.min(arr[0] * (N/6) + arr[1] * (N%6), arr[0] * (N/6 + (N%6 == 0 ? 0 : 1))));
        }
    }
}
