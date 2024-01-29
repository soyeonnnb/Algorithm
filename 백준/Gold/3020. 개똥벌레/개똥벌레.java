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
        int H=Integer.parseInt(st.nextToken());
        int[] arr = new int[H+1];
        for(int i=0;i<N;i++) {
            int input = Integer.parseInt(br.readLine());
            if (i%2 == 0) {
                arr[1]++;
                arr[input+1]--;
            } else {
                arr[H-input+1]++;
            }
        }
        for(int i=1;i<=H;i++) arr[i] += arr[i-1];
        int min = N;
        int number = 0;
        for(int i=1;i<=H;i++) {
            if (min > arr[i]) {
                min = arr[i];
                number = 1;
            } else if (min == arr[i]) number++;
        }
        System.out.println(min+" "+number);
    }
}