import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int[] arr = new int[A];
            int[] brr = new int[B];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<A;i++) arr[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<B;i++) brr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(brr);
            int count = 0;
            for(int i=0;i<A;i++) {
                count += binary(brr, arr[i]) + 1;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    // brr에서 num보다 작은 애중에 가장 큰 애 구하기
    private static int binary(int[] brr, int num) {
        int s = 0;
        int e = brr.length - 1;
        int ans = -1;
        while(s <= e) {
            int mid = (s+e) / 2;
            if (brr[mid] < num) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }
}