
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N=Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>();
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String flag = st.nextToken();
            if (flag.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        List<String> result = new ArrayList<>(set);
        result.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String str : result) sb.append(str).append("\n");
        System.out.println(sb);
    }
}
