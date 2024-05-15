import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

// 12:18 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] arr = new int[K][2];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        boolean[] caseX = new boolean[]{true, true, false, false};
        boolean[] caseY = new boolean[]{true, false, true, false};

        for(int i=0;i<K;i++) {
            for(int j=0;j<K;j++) {
                int x = arr[i][0];
                int y = arr[j][1];
                for(int k=0;k<4;k++) {
                    int result = 0;
                    for(int l=0;l<K;l++) {
                        if (isRange(arr[l][0], arr[l][1], x, y, caseX[k], caseY[k], L)) result++;
                    }
                    ans =Math.max(ans, result);
                }
            }
        }
        System.out.println(K - ans);
    }
    private static boolean isRange(int x, int y, int flagX, int flagY, boolean xBig, boolean yBig, int L) {
        // 해당 좌표를 기준으로 1, 2, 3, 4분면에 위치하는지부터 확인
        if (xBig && x < flagX) return false;
        else if (!xBig && x > flagX) return false;
        if (yBig && y < flagY) return false;
        else if (!yBig && y > flagY) return false;
        // 만약에 해당 위치에 존재한다면, 트램펄린 범위 내에 있는지 확인
        if (Math.abs(x - flagX) <= L && Math.abs(y - flagY) <= L) return true;
        return false;
    }
}