import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[][] dots;
    private static int[] dx = new int[]{0, -1, 0, 1};
    private static int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        dots = new boolean[101][101];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            int G=Integer.parseInt(st.nextToken());
            list.clear();
            list.add(d);
            dots[x][y] = true;
            x+=dx[d];
            y+=dy[d];
            dots[x][y] = true;
            for(int g=1;g<=G;g++) {
                int sz=list.size();
                for(int s=sz-1;s>=0;s--) {
                    int nd = (list.get(s) + 1)%4;
                    x += dx[nd];
                    y += dy[nd];
                    dots[x][y] = true;
                    list.add(nd);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                if (dots[i][j] && dots[i+1][j] && dots[i][j+1] && dots[i+1][j+1]) ans++;
            }
        }
        System.out.println(ans);
    }
}