import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Set<Integer> xset = new TreeSet<>();
        Set<Integer> yset = new TreeSet<>();
        for(int i=0;i<N;i++) {
            xset.add(list.get(i)[0]);
            yset.add(list.get(i)[1]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(0+" ");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n=2;n<=N;n++) { // n개가 모이는 것
            int answer = Integer.MAX_VALUE;
            for(Integer x : xset) {
                for(Integer y : yset) {
                    queue.clear();
                    for(int i=0;i<N;i++) queue.add(Math.abs(x - list.get(i)[0]) + Math.abs(y - list.get(i)[1]));
                    int temp = 0;
                    for(int i=0;i<n;i++) temp += queue.poll();
                    answer = Math.min(answer, temp);
                }
            }
            sb.append(answer+" ");
        }
        System.out.println(sb);

    }
}