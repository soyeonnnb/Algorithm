import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());

        if (N == 1) {
            System.out.println("A");
            return;
        }
        Set<Long> set = new HashSet<>();
        long ans = 0L;
        outer: for(int a = -10000;a <= 10000 ; a ++) {
            long mul = a * arr[0];
            long b = arr[1] - mul;

//            if (b < -10000 || b > 10000) continue;

            for(int i=0;i<N-1;i++) {
                if (arr[i] * a + b != arr[i+1]) continue outer;
            }
            set.add(arr[N-1] * a + b);
            ans = arr[N-1] * a + b;
        }
        if (set.isEmpty()) System.out.println("B");
        else if (set.size() > 1) System.out.println("A");
        else System.out.println(ans);

    }
}