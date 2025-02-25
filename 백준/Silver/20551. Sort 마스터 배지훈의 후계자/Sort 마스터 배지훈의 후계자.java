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
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            Integer n = Integer.parseInt(br.readLine());
            sb.append(binary(arr, n)).append("\n");
        }
        System.out.println(sb);
    }
    private static int binary(int[] arr, int num) {
        int s = 0;
        int e = arr.length-1;
        int ans = -1;
        while(s<=e) {
            int mid = (s+e) /2;
            if (arr[mid] == num) {
                ans = mid;
                e = mid - 1;
            } else if (arr[mid] > num) {
                e = mid-1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }
}