import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int size = 1000000;
//        int size = 30;
        int[] arr = new int[size + 10];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (s-t < 0) {
                System.out.println(-1);
                return;
            }
            arr[s]--;
            arr[s-t]++;
        }

        for(int i=1;i<=size;i++) arr[i] += arr[i-1];

        int remain = 0;
        int ans = size;
        for(int i=size;i>=0;i--) {
            if (arr[i] == 0) {
                if (remain != 0) {
                    remain--;
                    if (remain == 0) ans = i;
                }
            } else {
                remain += arr[i] - 1;
                ans = i;
            }
        }
        if (remain != 0) System.out.println(-1);
        else System.out.println(ans);
//        System.out.println(Arrays.toString(arr));
    }

}