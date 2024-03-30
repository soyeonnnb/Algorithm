import java.util.Arrays;
import java.util.Scanner;

// 16:15 ~
public class Main {
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L=sc.nextInt();
        int R=sc.nextInt();
        arr = new int[100010];
        visited = new boolean[100010];
        Arrays.fill(arr, 10); // 10은 아직 계산이 안된거
        int sum = 0;
        for(int x=L;x<=R;x++) {
            Arrays.fill(visited, false);
            sum += recur(x);
        }
        System.out.println(sum);
        
    }
    private static int recur(int cur) {
        if (cur > 100000) return -1;
        if (arr[cur] != 10) return arr[cur];
        else if (visited[cur]) {
            arr[cur] = 0;
            return 0;
        }
        visited[cur] = true;
        int sum = 0;
        int mul = 1;
        int num = cur;
        while(num != 0) {
            sum += num%10;
            mul *= num%10;
            num /= 10;
        }
        int now = Integer.parseInt(String.valueOf(sum)+mul);
        if (cur == now) arr[cur] = 1;
        else if (now > 100000) arr[cur] = -1;
        else if (visited[now]) arr[cur] = 0;
        else arr[cur] = recur(now);
        return arr[cur];
    }
}