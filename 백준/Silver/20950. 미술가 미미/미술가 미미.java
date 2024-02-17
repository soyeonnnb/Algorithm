import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] rgb;
    private static int[] bear;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        rgb = new int[N][3];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) rgb[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        bear = new int[3];
        for(int i=0;i<3;i++) bear[i] = Integer.parseInt(st.nextToken());
        answer = 987654321;
        recur(0, 0, 0, 0, 0);
        System.out.println(answer);
    }

    private static int check(int red, int green, int blue, int count) {
        return Math.abs((red/count)-bear[0]) + Math.abs((green/count)-bear[1]) + Math.abs((blue/count)-bear[2]);
    }

    private static void recur(int cur, int red, int green, int blue, int count) {
        if (count > 7) return;
        else if (cur == N) {
            if (count > 1) {
                answer = Math.min(answer, check(red, green, blue, count));
            }
            return;
        }
        recur(cur+1, red+rgb[cur][0], green+rgb[cur][1], blue+rgb[cur][2], count+1);
        recur(cur+1, red, green, blue, count);

    }
}