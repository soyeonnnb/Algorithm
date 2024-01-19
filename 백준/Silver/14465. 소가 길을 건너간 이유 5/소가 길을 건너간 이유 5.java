import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<B;i++) set.add(Integer.parseInt(br.readLine()));
        int answer = 0;
        for(int i=1;i<=K;i++) if(set.contains(i)) answer++;
        int s = 1;
        int e = K;
        int sum = answer;
        while(e<=N) {
            answer = answer < sum ? answer : sum;
            s++;
            e++;
            if (set.contains(s-1)) sum--;
            if (set.contains(e)) sum++;
        }
        System.out.println(answer);
    }
}