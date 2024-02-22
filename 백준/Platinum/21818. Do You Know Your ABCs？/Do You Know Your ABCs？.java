import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static int[] arr, nums;
    private static boolean[] visited;
    private static int answer, N;
    private static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        nums = new int[7];
        visited = new boolean[7];
        set = new TreeSet<>();
        for(int tc=1;tc<=T;tc++) {
            N=Integer.parseInt(br.readLine());
            arr = new int[N];
            set.clear();
            Arrays.fill(nums, 0);
            Arrays.fill(visited, false);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            answer = 0;
            recur(0);
            System.out.println(set.size());

        }
    }
    private static boolean check() {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if (a == 0 && b == 0 && c == 0) {
            a = nums[6] - nums[4];
            b = nums[6] - nums[5];
            c = nums[6] - nums[3];
            if (a < 1 || b < 1 || c < 1) return false;
        }
        if (visited[3]) {
            if (a == 0 && b != 0) {
                a = nums[3] - b;
            } else if (a != 0 && b == 0) {
                b = nums[3] - a;
            }
        }
        if (visited[4]) {
            if (b == 0 && c != 0) {
                b = nums[4] - c;
            }
            else if (b != 0 && c == 0) {
                c = nums[4] - b;
            }
        }
        if (visited[5]) {
            if (a == 0 && c != 0) {
                a = nums[5] - c;
            }
            else if (a != 0 && c == 0) {
                c = nums[5] - a;
            }
        }
        if (visited[6]) {
            if (a == 0 && visited[4])  a = nums[6] - nums[4];
            if (b == 0 && visited[5])  b = nums[6] - nums[5];
            if (c == 0 && visited[3])  c = nums[6] - nums[3];
        }

//        if (a == 0 || b == 0 || c == 0)
//        System.out.println("x "+a +" "+b +" "+c + Arrays.toString(nums));
        if (1 <= a && a <= b && b <= c) {
            if (nums[3] != 0 && a + b != nums[3]) return false;
            if (nums[4] != 0 && b + c != nums[4]) return false;
            if (nums[5] != 0 && a + c != nums[5]) return false;
            if (nums[6] != 0 && a + b + c != nums[6]) return false;
//            System.out.println("o "+a +" "+b +" "+c + Arrays.toString(nums));
            set.add(a+" "+b+" "+c);
            return true;
        }
        else return false;

    }

    private static void recur(int cur) {
        if (cur == N) {
            if (check()) answer++;
            return;
        }
        for(int i=0;i<7;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            nums[i] = arr[cur];
            recur(cur+1);
            nums[i] = 0;
            visited[i] = false;
        }
    }
}