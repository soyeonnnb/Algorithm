import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Cctv {
        int x, y, num;
        boolean[] dire;
        public Cctv (int x, int y, int num){
            this.x=x;
            this.y=y;
            this.num=num;
            this.dire = new boolean[4];
        }
    }
    private static int N, M;
    private static int[][] arr;
    private static List<Cctv> list;
    private static int size;
    private static boolean[][] checked;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr= new int[N][M];
        checked = new boolean[N][M];
        list = new ArrayList<>();
        answer=987654321;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >=1 && arr[i][j] <= 5) list.add(new Cctv(i, j, arr[i][j]));
            }
        }
        size = list.size();
        recur(0);
        System.out.println(answer);

    }

    private static int[] dx = new int[] {-1, 0, 1, 0};
    private static int[] dy = new int[] {0, -1, 0, 1};

    private static void check(int x, int y, int num) {
        int nx = x;
        int ny = y;
        while(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 6) {
            checked[nx][ny] = true;
            nx += dx[num];
            ny += dy[num];
        }
    }

    private static void recur(int cur) {
        if (cur == size) {
            for(int i=0;i<N;i++) Arrays.fill(checked[i], false);
            for(int i=0;i<size;i++) {
                for(int j=0;j<4;j++) if (list.get(i).dire[j]) check(list.get(i).x, list.get(i).y, j);
            }
            int sum = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) if (!checked[i][j] && arr[i][j] == 0) sum++;
            }
            answer = Math.min(answer, sum);
            return;
        }
        switch (list.get(cur).num) {
            case 1:
                for(int i=0;i<4;i++) {
                    list.get(cur).dire[i] = true;
                    recur(cur+1);
                    list.get(cur).dire[i] = false;
                }
                break;
            case 2:
                Arrays.fill(list.get(cur).dire, false);
                list.get(cur).dire[0] = true;
                list.get(cur).dire[2] = true;
                recur(cur+1);
                Arrays.fill(list.get(cur).dire, false);
                list.get(cur).dire[1] = true;
                list.get(cur).dire[3] = true;
                recur(cur+1);
                break;
            case 3:
                for(int i=0;i<4;i++) {
                    list.get(cur).dire[i] = true;
                    list.get(cur).dire[i+1 < 4 ? i+1 : 0] = true;
                    recur(cur+1);
                    list.get(cur).dire[i] = false;
                    list.get(cur).dire[i+1 < 4 ? i+1 : 0] = false;
                }
                break;
            case 4:
                Arrays.fill(list.get(cur).dire, true);
                for(int i=0;i<4;i++) {
                    list.get(cur).dire[i] = false;
                    recur(cur+1);
                    list.get(cur).dire[i] = true;
                }
                break;
            case 5:
                Arrays.fill(list.get(cur).dire, true);
                recur(cur+1);
                break;
        }

    }

}