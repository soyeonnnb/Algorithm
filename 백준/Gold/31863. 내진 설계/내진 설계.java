import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 10:49 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int[][] visited = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (arr[i][j] == '@') {
                    for(int k=0;k<4;k++) {
                        for(int l=1;l<=2;l++) {
                            int nx = i + dx[k]*l;
                            int ny = j + dy[k]*l;
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if (arr[nx][ny] == '|') break;
                            visited[nx][ny] ++;
                            if (arr[nx][ny] == '*') {
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0;k<4;k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                visited[nx][ny] ++ ;
                if ((arr[nx][ny] == '*' && visited[nx][ny] == 1) || (arr[nx][ny] == '#' && visited[nx][ny] == 2)) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        int destroyed = 0;
        int notDestroyed = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (arr[i][j] == '*') {
                    if (visited[i][j] >= 1) destroyed++;
                    else notDestroyed++;
                }
                else if (arr[i][j] == '#') {
                    if (visited[i][j] >= 2) destroyed++;
                    else notDestroyed++;
                }
            }
        }
        System.out.println(destroyed+" "+notDestroyed);

    }
}