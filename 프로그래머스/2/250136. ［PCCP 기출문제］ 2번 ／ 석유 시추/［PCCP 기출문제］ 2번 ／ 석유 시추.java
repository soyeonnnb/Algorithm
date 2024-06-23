import java.util.*;

class Solution {
    public int solution(int[][] land) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 2;
        int N=land.length;
        int M=land[0].length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (land[i][j] != 1) continue;
                Queue<int[]> queue = new LinkedList<>();
                int size = 1;
                count++;
                land[i][j] = count;
                queue.add(new int[]{i, j});
                while(!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for(int k=0;k<4;k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || land[nx][ny] != 1) continue;
                        queue.add(new int[]{nx, ny});
                        size++;
                        land[nx][ny] = count;
                    }
                }
                map.put(count, size);
            }
        }
        int answer = 0;
        for(int j=0;j<M;j++) {
            int result = 0;
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<N;i++) {
                if (land[i][j] == 0 || set.contains(land[i][j])) continue;
                set.add(land[i][j]);
                result += map.get(land[i][j]);
            }
            answer = Math.max(answer, result);
        }
        return answer;
    }
}