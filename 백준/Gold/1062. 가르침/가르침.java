import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int ans = 0, K;
    private static Set<Integer> visited;
    private static Set<Integer>[] sets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        if (K < 5) {
            System.out.println(0);
            return;
        }

        visited = new HashSet<>();
        char[] defaultChar = {'a', 'n', 't', 'i', 'c'};
        for(char c : defaultChar) visited.add(c - 'a');

        sets = new Set[N];
        for(int i=0;i<N;i++) {
            sets[i] = new HashSet<>();
            String str = br.readLine();
            for(int j=4;j<str.length()-4;j++) sets[i].add(str.charAt(j) - 'a');
        }
        recur(0, 0);
        System.out.println(ans);
    }

    private static void recur(int cur, int cnt) {
        if (cnt == K-5) {
            int res = 0;
            outer: for(Set<Integer> nset : sets) {
                for(int n : nset) {
                    if (!visited.contains(n)) continue outer;
                }
                res++;
            }
            ans = Math.max(ans, res);
            return;
        }

        if (cur > 26) return;

        for(int i=cur;i<26;i++) {
            if (visited.contains(i)) continue;
            visited.add(i);
            recur(i+1, cnt+1);
            visited.remove(i);
        }
    }

}