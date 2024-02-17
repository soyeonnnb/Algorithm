import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int L, C;
    private static char[] arr;
    private static char[] answer;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr = new char[C];
        answer = new char[L];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++) arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);
        recur(0, 0, 0);
        System.out.println(sb);
    }
    private static void recur(int cur, int num, int vow) { // vow-> 모음, con -> 자음
        if (cur == L) {
            if (vow < 1 || L - vow < 2) return;
            for(int i=0;i<L;i++) sb.append(answer[i]);
            sb.append("\n");
            return;
        }
        for(int i=num;i<C;i++) {
            answer[cur] = arr[i];
            recur(cur+1, i+1, isVow(arr[i]) ? vow + 1 : vow);
        }
    }
    private static boolean isVow (char c) {
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
}