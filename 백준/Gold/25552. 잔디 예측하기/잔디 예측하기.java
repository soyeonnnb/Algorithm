import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16:21
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M];
        boolean[][] arr = new boolean[N][M];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                if (str.charAt(j) == 'O') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int D=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = str.charAt(j) == 'O';
                if(arr[i][j] && !visited[i][j]) count++;
                if(!arr[i][j] && visited[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int xd=-D;xd<=D;xd++) {
                for(int yd=-D;yd<=D;yd++) {
                    if (Math.abs(xd) + Math.abs(yd) > D) continue;
                    int nx = now[0] + xd;
                    int ny = now[1] + yd;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (!arr[nx][ny] || visited[nx][ny]) continue;
                    count--;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (arr[i][j] && !visited[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}