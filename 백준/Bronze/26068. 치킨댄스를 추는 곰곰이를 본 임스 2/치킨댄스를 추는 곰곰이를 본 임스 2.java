import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0;i<N;i++) {
            int x =Integer.parseInt(br.readLine().split("-")[1]);
            if (x <= 90) ans++;
        }
        System.out.println(ans);
    }
}