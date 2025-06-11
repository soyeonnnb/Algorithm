
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        if (N == 0) {
            System.out.println(0);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int count = 0;
        for(int i=0;i<N;i++) {
            int input = Integer.parseInt(st.nextToken());
            if (sum + input > M) {
                count ++;
                sum = input;
            } else {
                sum += input;
            }
        }
        System.out.println(count+1);
    }
}
