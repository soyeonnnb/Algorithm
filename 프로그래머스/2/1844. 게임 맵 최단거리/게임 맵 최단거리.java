import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int N=maps.length;
        int M=maps[0].length;
        
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int length = 1;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            length++;
            for(int s=0;s<sz;s++) {
                int[] now = queue.poll();
                for(int k=0;k<4;k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || maps[nx][ny] == 0) continue;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    if (nx == N-1 && ny == M-1) return length;
                }
            }
        }
        return -1;
    }
}