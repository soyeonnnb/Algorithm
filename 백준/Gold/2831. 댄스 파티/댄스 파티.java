import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        int[] girls = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n < 0) minus.add(-n);
            else plus.add(n);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) girls[i] = Integer.parseInt(st.nextToken());
        minus.sort(Comparator.naturalOrder());
        plus.sort(Comparator.reverseOrder());
        Arrays.sort(girls);

        int s = 0;

        int e = 0;
        while(e < N && girls[e] < 0) e++;

        int ans = 0;
        outer: for(int i=0;i<minus.size();i++) {
            // 남자는 키가 작은 사람 == 여자는 자기보다 키가 큰 사람(양수)
            while(e < N && girls[e] > 0) {
                if (minus.get(i) > Math.abs(girls[e])) {
                    ans++;
                    e++;
                    continue outer;
                } else {
                    continue outer;
                }
            }
        }

        outer: for(int i=0;i<plus.size();i++) {
            // 남자는 키가 큰 사람 == 여자는 자기보다 키가 작은 사람(음수)
            while(s < N && girls[s] < 0) {
                if (plus.get(i) < Math.abs(girls[s])) {
                    ans++;
                    s++;
                    continue outer;
                } else {
                   continue outer;
                }
            }
        }


        System.out.println(ans);
    }
}