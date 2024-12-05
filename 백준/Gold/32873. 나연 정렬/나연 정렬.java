import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

// 20:56 ~
public class Main {

    private static int[] stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        stack = new int[N];
        stack[0] = arr[N-1];
        int end = 0;
        for(int i=N-2;i>=0;i--) {
            int idx = binary(0, end, arr[i]);
            stack[idx] = arr[i];
            end = Math.max(idx, end);
//            System.out.println(i+" "+ Arrays.toString(stack));
        }
        System.out.println(end+1);
    }

    private static int binary(int s, int e, int num) {
       int ans = e+1;
       while(s <= e) {
           int mid = (s+e)/2;
           if (stack[mid] == num) return mid;
           else if (stack[mid] <= num) {
                ans = mid;
                e = mid-1;
           } else {
               s = mid+1;
           }
       }
       return ans;
    }
}