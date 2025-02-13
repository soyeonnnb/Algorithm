import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        // 1개인 경우
        for(int i=0;i<N;i++) {
            if (arr[i] == C) {
                System.out.println(1);
                return;
            }
        }

        // 2개인 경우
        if (pointer(C, arr, N, N)) {
            System.out.println(1);
            return;
        }

        if (N < 3) {
            System.out.println(0);
            return;
        }

        if (N == 3) {
            if (arr[0] + arr[1] + arr[2] == C) {
                System.out.println(1);
                return;
            }
        }

        // 4개 이상 경우
        for(int i=0;i<N;i++) {
            if (pointer(C - arr[i], arr, i, N)) {
                System.out.println(1);
//                System.out.println("1: 3개인 경우: "+i);
                return;
            }
        }

        System.out.println(0);

    }

    private static boolean pointer(int target, int[] arr, int idx, int N) {
        int s = idx == 0 ? 1 : 0;
        int e = idx == N-1 ? N-2 : N-1;
        while(s<e) {
            if (arr[s] + arr[e] == target) {
                return true;
            } else if (arr[s] + arr[e] < target) {
                s++;
                if (s == idx) s++;
            } else {
                e--;
                if (e == idx) e--;
            }
        }
        return false;
    }
}