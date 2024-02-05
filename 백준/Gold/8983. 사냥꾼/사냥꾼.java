import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int[] marr =new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) marr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(marr);
        int[][] arr =new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 이번에는 사대를 정렬해서
        // 해당 동물과 가장 가까운 사대 찾고,
        // 그 사대에 범위내에 들어가는지 확인해보자 -> 왜냐면 사정거리가 같으니까 사대 가까운만큼 갈 수 있음.
        int answer = 0;
        for(int[] animal : arr) {
            int s = 0;
            int e = M-1;
            while(s<=e) {
                int mid = (s+e)/2;
                if (Math.abs(marr[mid] - animal[0]) + animal[1] <= L) {
                    answer++;
                    break;
                }
                if (marr[mid] < animal[0]) {
                    s = mid+1;
                } else {
                    e = mid-1;
                }
            }
        }
        System.out.println(answer);
    }
}