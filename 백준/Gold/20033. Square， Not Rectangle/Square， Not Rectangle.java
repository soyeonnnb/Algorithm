import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int answer = 1;
        // 모든 변에 대해서 사각형이 만들어질 수 있는지 확인하는 것은 너무 힘듬
        // 따라서 아예 변을 정해서, 해당 변으로 쭉 돌고 사각형이 만들어질 수 있는지 확인하기
        int s = 1;
        int e = 1;
        for(int i=0;i<N;i++) e = Math.max(e, arr[i]);
        while(s<=e) {
            int mid = (s+e)/2;
            boolean checked = false;
            int temp = 0;
            for(int i=0;i<N;i++) {
                if (arr[i] >= mid) {
                    temp++;
                } else {
                    temp = 0;
                }
                if (temp == mid) {
                    checked = true;
                    break;
                }
            }
            if (!checked) {
                e = mid-1;
            } else {
                answer = mid;
                s = mid+1;
            }
        }
        System.out.println(answer);
    }
}