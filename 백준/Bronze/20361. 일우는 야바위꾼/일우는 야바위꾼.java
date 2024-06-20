import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int X=Integer.parseInt(st.nextToken()); // 현재 공 위치
        int K=Integer.parseInt(st.nextToken());
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (X == a) {
                X = b;
            } else if (X == b) {
                X = a;
            }
        }
        System.out.println(X);
    }
}