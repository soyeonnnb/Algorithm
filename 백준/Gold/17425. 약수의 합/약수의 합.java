import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        final int RANGE = 1_000_000;
        StringBuilder sb = new StringBuilder();
        long[] arr = new long[RANGE+1];
        for(int num=1;num<=RANGE;num++) {
            for(int i=1;i*num<=RANGE;i++) {
                arr[num*i]+=num;
            }
        }
        for(int i=1;i<=RANGE;i++) arr[i] += arr[i-1];
        for(int tc=1;tc<=T;tc++) {
            int N=Integer.parseInt(br.readLine());
            sb.append(arr[N]).append("\n");
        }
        System.out.println(sb);
    }
}
