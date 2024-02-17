import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] arr, num;
    private static int B, N;
    private static int answer;
    private static boolean fin;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A=sc.next();
        B=sc.nextInt();
        N=A.length();
        arr = new int[N];
        num = new int[N];
        fin=false;
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            arr[i] = A.charAt(i)-'0';
        }
        answer = -1;
        Arrays.sort(arr);
        recur(0);
        System.out.println(answer);
    }
    private static int getNum() {
        int answer = 0;
        for(int i=0;i<N;i++) {
            answer *= 10;
            answer += arr[num[i]];
        }
        return answer;
    }

    private static void recur(int cur) {
        if (fin) return;
        if (cur >= 1 && arr[num[0]] == 0) return;
        if (cur == N){
            int result = getNum();
            if (result >= B) {
                fin = true;
            } else {
                answer = result;
            }
            return;
        }
        for(int i=0;i<N;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            num[cur] = i;
            recur(cur+1);
            visited[i] = false;
        }
    }

}