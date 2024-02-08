import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringBuilder[] arr = new StringBuilder[C];
        for(int i=0;i<C;i++) arr[i] = new StringBuilder();
        Set<String> set = new TreeSet<>();
        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) arr[j].append(str.charAt(j));
        }
        int answer = 0;
        outer: for(int i=0;i<R;i++) {
            set.clear();
            for(int j=0;j<C;j++) {
                arr[j].deleteCharAt(0);
                if (set.contains(arr[j].toString())) break outer;
                set.add(arr[j].toString());
            }
            answer++;
        }
        System.out.println(answer);
    }
}