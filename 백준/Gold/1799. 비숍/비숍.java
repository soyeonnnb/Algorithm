import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, aAnswer, bAnswer;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        List<int[]> alist = new ArrayList<>();
        List<int[]> blist = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    if ((i+j)%2 == 0) alist.add(new int[]{i, j});
                    else blist.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[N][N];
        aAnswer = 0;
        bAnswer = 0;
        recur(0, 0, alist, true);
        recur(0, 0, blist, false);
        System.out.println(aAnswer+bAnswer);
    }
        private static void recur(int cur, int result, List<int[]> list, boolean isA) {
        if (cur == list.size()) {
            if (isA) aAnswer = Math.max(aAnswer, result);
            else bAnswer = Math.max(bAnswer, result);
            return;
        }
        // 비숍을 안놓았을 때
        recur(cur+1, result, list, isA);
        // 놓을 수 있으면 놓는다.
        if (check(cur, list)) {
            visited[list.get(cur)[0]][list.get(cur)[1]] = true;
            recur(cur+1, result+1, list, isA);
            visited[list.get(cur)[0]][list.get(cur)[1]] = false;
        }
    }

    private static boolean check(int cur, List<int[]> list) {
        int x = list.get(cur)[0];
        int y = list.get(cur)[1];
        int i = x;
        int j = y;
        while(i>=0 && j >= 0) {
            if (visited[i--][j--]) return false;
        }
        i=x;
        j=y;
        while(i>=0 && j < N) {
            if (visited[i--][j++]) return false;
        }
        return true;
    }
}