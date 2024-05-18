import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] nums, arr;
    private static boolean[] visited;
    private static int N, answerIndex;
    private static boolean finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N=str.length();
        arr =new int[N];
        for(int i=0;i<N;i++) arr[i] = str.charAt(i)-'0';
        nums = new int[50];
        visited = new boolean[51];
        answerIndex = 0;
        recur(0, 0);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < answerIndex;i++) {
            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb);
    }
    private static void recur(int index, int numsIndex) {
        if (finished) return;
        if (index == N) {
            if (check(numsIndex)) {
                finished = true;
                answerIndex = numsIndex;
            }
            return;
        }
        if (arr[index] == 0) return;
        // 한글자
        int num = arr[index];
        if (!visited[num]) {
            nums[numsIndex] = num;
            visited[num] = true;
            recur(index+1, numsIndex+1);
            visited[num] = false;
            if (finished) return;
        }

        // 두글자
        if (index + 1 >= N) return;
        num = arr[index]*10 + arr[index+1];
        if (index + 1 < N && num <= 50 && !visited[num]) {
            nums[numsIndex] = num;
            visited[num] = true;
            recur(index+2, numsIndex+1);
            visited[num] = false;
        }
    }
    private static boolean check(int idx) {
        for(int i=1;i<=idx;i++) if (!visited[i]) return false;
        return true;
    }
}