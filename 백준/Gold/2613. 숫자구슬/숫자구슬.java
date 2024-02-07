import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int s = 1;
        for(int i=0;i<N;i++) s = Math.max(s, arr[i]); // 이 이하로는 만들 수 없다 !
        int e = 0;
        for(int i=0;i<N;i++) e += arr[i];
//        int answer = 30000;
        List<Integer> answerArray = new ArrayList<>();
        List<Integer> tempArray = new ArrayList<>();
        while(s<=e) {
            int mid = (s+e)/2; // 이 크기가 최대일 때를 구할거다 !
            int sum = 0;
            int now = 0;
            tempArray.clear();
            for(int i=0;i<N;i++) {
                if ((now == 0 && N-i+tempArray.size() == M) || (now != 0 && N-i+tempArray.size()+1 == M)) {
                    if (now != 0) {
                        tempArray.add(now);
                    }
                    for(int j=i;j<N;j++) tempArray.add(1);
                    now = 0;
                    break;
                }
                if (sum + arr[i] > mid) { // 지금꺼를 넣으면 안되면
                    tempArray.add(now);
                    now = 1;
                    sum = arr[i];
                } else if (sum + arr[i] == mid) {
                    tempArray.add(now+1);
                    now = 0;
                    sum = 0;
                } else {
                    now++;
                    sum += arr[i];
                }
            }
            if (now != 0) tempArray.add(now);
            if (tempArray.size() <= M) { // 너무 크게 생각함 !
//                answer = mid;
                answerArray.clear();
                for(int t : tempArray) answerArray.add(t);
                e = mid-1; // 더 작게 생각해보자
            } else if (tempArray.size() > M) { // 이렇게 하면 최댓값이 mid가 아님 !
                s = mid+1;
            }
        }
        int answer =0 ;
        int i=0;
        for(int n : answerArray) {
            int temp  =0;
            for(int j=1;j<=n;j++) {
                temp += arr[i];
                i++;
            }
//            System.out.println(n+" "+temp);
            answer = Math.max(temp, answer);
        }
        System.out.println(answer);
        for(int a : answerArray) System.out.print(a+" ");
    }
}