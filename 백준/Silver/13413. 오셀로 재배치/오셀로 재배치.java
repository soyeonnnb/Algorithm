import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[2];
        for(int tc=1; tc<=T;tc++) {
            int N=Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();
            Arrays.fill(arr, 0);
            for(int i=0;i<N;i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    if (str2.charAt(i) == 'W') {
                        arr[0]++;
                    } else {
                        arr[1]++;
                    }
                }
            }
            int ans = Math.min(arr[0], arr[1]) + Math.abs(arr[0] - arr[1]);
            System.out.println(ans);
        }
    }
}
