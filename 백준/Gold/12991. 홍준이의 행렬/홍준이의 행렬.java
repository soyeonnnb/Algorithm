import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// K 번째 수 문제 토대로 혼자 풀어보기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        long[] A = new long[N];
        long[] B = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) A[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) B[i] = Long.parseLong(st.nextToken());
        Arrays.sort(A);
        Arrays.sort(B);
        long s = A[0] * B[0]; // 나올 수 있는 가장 작은 수
        long e = A[N-1] * B[N]; // 나올 수 있는 가장 큰 수
        long answer = 0;
        while(s<=e) {
            long mid = (s+e)/2; // 만약 mid가 K번째 수라면
            int sum = 0; // 각 행에 대하여 mid보다 작거나 같은 수의 개수
            for(int i=0;i<N;i++) { // 각 행을 돌면서
                int ts = 1; // 열의 0번째
                int te = N; // 열의 N-1번째
                int ta = 0; // mid보다 작은 것 들중 가장 큰 수의 인덱스
                while(ts<=te) {
                    int mt = (ts+te)/2;
                    if (A[i] * B[mt] <= mid) {
                        ta = mt;
                        ts = mt+1;
                    } else {
                        te = mt-1;
                    }
                }
                sum += ta;
            }
            if (sum < K) { // 만약 sum이 K보다 작다면 무조건 mid보다 큰 수가 K번째 수이다.
                s = mid+1;
            } else { // 만약 sum이 K보다 크다면, 답일 확률이 높고, 더 작은수가 K번째 수 일수도 있다.
                answer = mid;
                e = mid-1;
            }
        }
        System.out.println(answer);
    }
}