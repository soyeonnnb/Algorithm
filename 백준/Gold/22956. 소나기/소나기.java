import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;
    private static int[][][] land;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());

        // 부모 x, 부모 y, 언제 비가 내렸는지
        parent = new int[1000010];
        for(int i=0;i<=1000000;i++) parent[i] = i;
        land = new int[N][M][2]; // 땅 높이, 갱신된 시점
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) land[i][j][0] = Integer.parseInt(st.nextToken());
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        StringBuilder sb = new StringBuilder();
        for(int q=1;q<=Q;q++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            // 일단 비를 내림
            land[a][b][0] -= c;
            land[a][b][1] = q;

            // 현재 칸이 부모가 아니면 부모 갱신
            if (parent[a*1000+b] != a*1000+b) {
                int root = findset(a*1000+b);
                int rx = root/1000;
                int ry = root%1000;
                // 만약 갱신돼도 되면
                if (land[rx][ry][0] > land[a][b][0]) {
                    parent[root] = a*1000+b;
                    parent[a*1000+b] = a*1000+b;
                }
            }

            // 사방에 물이 있는지 확인
            for(int k=0;k<4;k++) {
                int nx = a + dx[k];
                int ny = b + dy[k];
                // 범위 밖이거나 아직 비가 안왔으면 넘어감
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || land[nx][ny][1] == 0) continue;
                // 합침
                union(a, b, nx, ny);
            }

            int root = findset(a*1000 + b);
            sb.append(root/1000+1).append(" ").append(root%1000+1).append("\n");
        }
        System.out.println(sb);

    }
    private static int findset(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findset(parent[x]);
    }

    private static boolean union(int x1, int y1, int x2, int y2) {
        int r1 = findset(x1*1000 + y1);
        int r2 = findset(x2*1000 + y2);
        if (r1 == r2) return false;

        // 합칠 때에는 물의 높이를 확인해야 함
        // 물높이가 같으면 내린 지 더 오래된 칸
        int rx1 = r1/1000;
        int ry1 = r1%1000;
        int rx2 = r2/1000;
        int ry2 = r2%1000;

        // 만약 물높이가 같다면
        if (land[rx1][ry1][0] == land[rx2][ry2][0]) {
            // 더 이전에 한거가 루트가 됨
            if (land[rx1][ry1][1] < land[rx2][ry2][1]) {
                parent[r2] = r1;
            } else {
                parent[r1] = r2;
            }
        } else if (land[rx1][ry1][0] < land[rx2][ry2][0]){ // 다르면
            parent[r2] = r1;
        } else {
            parent[r1] = r2;
        }
        return true;
    }
}