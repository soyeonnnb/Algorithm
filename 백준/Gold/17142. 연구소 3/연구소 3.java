import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 15:00 ~
public class Main {
    private static int N, M, fill, ans, testcase;
    private static int[][] arr, visited;
    private static List<int[]> virusList;
    private static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        virusList = new ArrayList<>();
        fill = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) fill++;
                else if (arr[i][j] == 2) virusList.add(new int[]{i, j});

            }
        }
        testcase = 0;
        visited = new int[N][N];
        checked = new boolean[virusList.size()];
        ans = -1;
        if (fill == 0) {
            System.out.println(0);
            return;
        }
        recur(0, 0);
        System.out.println(ans);
    }
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static void recur(int virusIdx, int virusNum) {
        if (virusNum == M) { // M개 다 선택함
            testcase++;
            queue.clear();
            int testfill = 0;
            // 초기값 넣기
            for(int i=0;i<virusList.size();i++) {
                if (checked[i]) {
                    queue.add(virusList.get(i));
                    visited[virusList.get(i)[0]][virusList.get(i)[1]] = testcase;
                }
            }
            int time = 0;
            outer: while(!queue.isEmpty()) {
                int size = queue.size();
                time ++ ;
                for(int s=0;s<size;s++) {
                    int[] now = queue.poll();
                    for(int k=0;k<4;k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 | ny >= N || arr[nx][ny] == 1 || visited[nx][ny] == testcase) continue;
                        visited[nx][ny] = testcase;
                        if (arr[nx][ny] == 0)
                            testfill++;
                        queue.add(new int[]{nx, ny});
                        if(testfill == fill) break outer;
                    }
                }
            }
            if (testfill == fill) ans = ans == -1 ? time : Math.min(ans, time);
            return;
        }

        for(int i=virusIdx;i<virusList.size();i++) {
            checked[i] = true;
            recur(i+1, virusNum+1);
            checked[i] = false;
        }
    }
}