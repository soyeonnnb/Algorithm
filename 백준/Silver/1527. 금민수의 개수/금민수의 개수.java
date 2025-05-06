
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int ans, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10];
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        ans = 0;
        recur(0);
        System.out.println(ans);
    }

    private static void recur(int index) {
        if (index >= 10) return;
        int now = makeNum(index);
        if (now >= A && now <= B) {
            ans++;
        }
        arr[index] = 4;
        recur(index+1);
        arr[index] = 7;
        recur(index + 1);
    }

    private static int makeNum(int index) {
        int result = 0;
        for(int i=0;i<index;i++) {
            result*=10;
            result+=arr[i];
        }
        return result;
    }
}
