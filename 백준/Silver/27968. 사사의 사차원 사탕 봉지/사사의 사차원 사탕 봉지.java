
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        long[] arr = new long[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++) arr[i] = Long.parseLong(st.nextToken());
        for(int i=1;i<=M;i++) arr[i] += arr[i-1];

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            long candy = Long.parseLong(br.readLine());
            long index = binary(arr, candy);
            if (index == -1L) sb.append("Go away!");
            else sb.append(index);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static long binary(long[] arr, long num) {
        int s = 0;
        int e = arr.length - 1;
        long ans = -1L;
        while(s <= e) {
            int mid = (s+e) / 2;
            if (arr[mid] == num) return mid;
            else if (arr[mid] < num) {
                s = mid + 1;
            } else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }
}
