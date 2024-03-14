class Solution {
    public int solution(String dirs) {
        // 상/하/우/좌
        int[] dx = new int[]{0, 0,-1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        boolean[][][] visited = new boolean[11][11][2];
        int x = 5;
        int y = 5;
        int answer = 0;
        int nx, ny;
        outer: for(int s=0;s<dirs.length();s++) {
            char method = dirs.charAt(s);
            switch(method) {
                case 'U':
                    nx = x + dx[0];
                    ny = y + dy[0];
                    if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue outer;
                    if (!visited[x][y][0]) {
                        visited[x][y][0] = true;
                        answer++;
                    }
                    x = nx;
                    y = ny;
                    break;
                case 'D':
                    nx = x + dx[1];
                    ny = y + dy[1];
                    if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue outer;
                    if (!visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        answer++;
                    }
                    x = nx;
                    y = ny;
                    break;
                case 'R':
                    nx = x + dx[2];
                    ny = y + dy[2];
                    if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue outer;
                    if (!visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        answer++;
                    }
                    x = nx;
                    y = ny;
                    break;
                case 'L':
                    nx = x + dx[3];
                    ny = y + dy[3];
                    if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue outer;
                    if (!visited[x][y][1]) {
                        visited[x][y][1] = true;
                        answer++;
                    }
                    x = nx;
                    y = ny;
                    break;
            }
        }
        return answer;
    }
}