import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        char[][] inputs = new char[N][N];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) inputs[i][j] = str.charAt(j);
        }
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++) Arrays.fill(arr[i], -1);
        int count = 0;
//        Map<Integer, Integer> map = new TreeMap<>();
        int[] countList = new int[1000001];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if ((i == 0 && j == 0) || (i == N-1 && j == N-1)) continue;
                else if (arr[i][j] != -1) continue;
                count++;
                queue.clear();
                int num = 1;
                arr[i][j] = count;
                queue.add(new int[]{i, j});
                while(!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for(int k=0;k<4;k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || inputs[i][j] != inputs[nx][ny] || arr[nx][ny] != -1) continue;
                        arr[nx][ny] = count;
                        num++;
                        queue.add(new int[]{nx, ny});
                    }
                }
                countList[count] = num;
            }
        }
//        for(int i=0;i<N;i++) System.out.println(Arrays.toString(arr[i]));
        Set<Integer>[] list = new Set[count+1];
        for(int i=0;i<=count;i++) list[i] = new TreeSet<>();
//        Map<Integer, Set<Integer>> linked = new TreeMap<>();

        // 특정 그래프에서 갈 수 있는 경로 구하기
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if ((i == 0 && j == 0) || (i == N-1 && j == N-1)) continue;
                for(int k=0;k<8;k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[i][j] == arr[nx][ny] || arr[nx][ny] == -1) continue;
                    list[arr[i][j]].add(arr[nx][ny]);
                }
            }
        }

        Set<Integer> answerList = new TreeSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[count+1];
        int answer = 10000000;

        for(int i=1;i<N;i++) {
            for(int j=0;j<N-1;j++) {
                if (i != N-1 && j != 0) continue;
                if (visited[arr[i][j]]) continue;
                pq.add(new int[]{arr[i][j], countList[arr[i][j]]});
                visited[arr[i][j]] = true;
            }
        }

        for(int i=0;i<N-1;i++) {
            for(int j=1;j<N;j++) {
                if (i != 0 && j != N-1) continue;
                if (visited[arr[i][j]]) {
                    answer = Math.min(answer,  countList[arr[i][j]]);
                }
                answerList.add(arr[i][j]);
            }
        }

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[1] > answer) break;
            for(int nxt : list[now[0]]) {
                if (visited[nxt]) continue;
                visited[nxt] = true;
                int cost = now[1] + countList[nxt];
                if (answerList.contains(nxt)) {
                    answer = Math.min(answer, cost);
                    continue;
                }
                pq.add(new int[]{nxt, cost});
            }
        }
        System.out.println(answer);
    }
}