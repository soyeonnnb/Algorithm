import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.interfaces.DSAKey;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int s = 1;
        int e = 0;
        for(int i=0;i<N;i++) {
            s = Math.max(arr[i], s); // 최소 구슬의 최소값
            e += arr[i]; // 최대 구슬의 수 합
        }
        List<Integer> answerList = new ArrayList<>();
        int answer = s;
        List<Integer> tempList = new ArrayList<>();
        while(s<=e) {
            int mid = (s+e)/2;
            tempList.clear();
            int group = 0;
            int cnt = 0;
            int sum = 0;
            for(int i=0;i<N;i++) {
                if (N-i == (M-group-(cnt == 0 ? 0 : 1))) {
                    break;
                }
                if (sum + arr[i] < mid) {
                    sum += arr[i];
                    cnt += 1;
                } else if (sum + arr[i] == mid) {
                    tempList.add(cnt+1);
                    sum = 0;
                    cnt = 0;
                    group ++;
                } else {
                    tempList.add(cnt);
                    group ++;
                    sum = arr[i];
                    cnt = 1;
                }
            }
            if (cnt != 0) {
                tempList.add(cnt);
                group++;
            }
            for(int i = group;i<M;i++) tempList.add(1);
            if (group <= M) {
                e = mid-1;
                answer = mid;
                answerList.clear();
                for(int num:tempList) answerList.add(num);
            } else {
                s = mid+1;
            }
        }
        System.out.println(answer);
        for(int num : answerList) System.out.print(num+" ");


    }
}