import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, idx;
    private static int[] in, post, pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        in = new int[N+1];
        post = new int[N+1];
        pre = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) in[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) post[i] = Integer.parseInt(st.nextToken());
        idx = 1;
        getPre(1, N, 1, N);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) sb.append(pre[i]).append(" ");
        System.out.println(sb);

    }
    private static void getPre(int in_s, int in_e, int post_s, int post_e) {
        if (idx > N || in_s > in_e || post_s > post_e || post_e < 1) return;
        pre[idx++] = post[post_e]; // 일단 루트는 post의 맨 끝
        int in_root = getroot(post[post_e]); // 현재 root 지점의 inorder에서의 위치
        int s_l = in_root - in_s - 1; // inorder 왼쪽 자식 길이
        getPre(in_s, in_root-1, post_s, post_s + s_l);
        getPre(in_root + 1, in_e, post_s + s_l + 1, post_e -1);
    }
    private static int getroot(int root) {
        for(int i=1;i<=N;i++) if(in[i] == root) return i;
        return 0;
    }
}