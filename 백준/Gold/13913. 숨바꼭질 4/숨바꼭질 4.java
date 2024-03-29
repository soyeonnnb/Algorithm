import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 19:57 ~
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        int[] arr = new int[120001];
        Arrays.fill(arr, -1);
        arr[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        int[] add = new int[]{-1, 1, 0};
        int[] mul = new int[]{1, 1, 2};
        outer: while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int k=0;k<3;k++) {
                int next = now * mul[k] + add[k];
                if (next < 0 || next >= 120000) continue;
                if (arr[next] != -1) continue;
                arr[next] = arr[now] + 1;
                queue.add(next);
                if (next == K) break outer;
            }
        }
        int[] result = new int[arr[K]+1];
        int idx = arr[K]-1;
        result[arr[K]] = K;
        int now = K;
        while(idx >= 0) {
            for(int k=0;k<3;k++) {
                int before = now/mul[k] + add[k];
                if (before < 0 || before >= 120000) continue;
                if (arr[before] == idx) {
                    result[idx] = before;
                    now = before;
                    break;
                }
            }
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[K]+"\n");
        for(int i=0;i<result.length;i++) sb.append(result[i]+" ");
        System.out.println(sb);
    }
}