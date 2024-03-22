import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

// 14:23 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }
        Arrays.sort(arr);
        long sum = 0;
        for(int i=0;i<N-1;i++) sum += arr[i];
        if (sum < arr[N-1]) {
            System.out.println(arr[N-1] - sum);
        } else {
            if (sum%2 == arr[N-1]%2) System.out.println(0);
            else System.out.println(1);
        }

    }
}
