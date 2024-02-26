import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, answer;
    private static int[] marr;
    private static int[][] arr;
    private static boolean[] checked;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        marr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[N][5];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        answer = -1;
        checked = new boolean[N];
        sb = new StringBuilder();
        recur(0, 0, 0, 0, 0, 0);
        System.out.println(answer);
        System.out.println(sb);

    }
    private static boolean check( int mp, int mf, int ms, int mv) {
        if (mp >= marr[0] && mf >= marr[1] && ms >= marr[2] && mv >= marr[3]) return true;
        else return false;
    }

    private static void recur(int cur, int mp, int mf, int ms, int mv, int price) {
        if (answer != -1 && answer < price) return;
        if (check(mp, mf, ms, mv)) {
            if (answer == -1 || price < answer) {
              answer = price;
              sb = new StringBuilder();
              for(int i=0;i<N;i++) if (checked[i]) sb.append((i+1)+" ");
            }
            return;
        }
        if (cur == N) return;
        checked[cur] = true;
        recur(cur+1, mp+arr[cur][0], mf+arr[cur][1], ms+arr[cur][2], mv+arr[cur][3], price+arr[cur][4]);
        checked[cur] = false;
        recur(cur+1, mp, mf, ms, mv, price);
    }

}