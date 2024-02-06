import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken() );
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        // 설치할 수 있는 간격을 설정해보자.
        int s = 1;
        int e = arr[N-1] - arr[0];
        int answer = 0;
        while(s<=e) {
            int mid = (s+e) /2;
            int temp = 1;
            int now = 0; // arr[0]에 하나 설치
            for(int i=1;i<N;i++) {
                now += arr[i] - arr[i-1];
                if (now >= mid) {
                    temp++;
                    now=0;
                }
            }

            if (temp < C) { // 해당 간격이 최대일 경우 공유기의 개수가 부족 -> 더 설치해야함 == 간격이 더 좁게
                e = mid-1;
            } else if (temp >= C) { // 해당 간격이 최대일 경우 공유기가 더 설치됨. == 간격을 더 넓혀도 됨
                s = mid + 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}