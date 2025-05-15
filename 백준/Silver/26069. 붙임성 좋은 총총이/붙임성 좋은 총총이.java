
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        map.put("ChongChong", 1);
        int count = 1;
        boolean[] visited = new boolean[2500];
        visited[1] = true;
        int ans = 1;
        for(int n=0;n<N;n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            Integer num1 = map.getOrDefault(str1, ++count);
            map.put(str1, num1);
            Integer num2 = map.getOrDefault(str2, ++count);
            map.put(str2, num2);
            if (visited[num1] && visited[num2]) continue;
            else if (visited[num1]) {
                visited[num2] = true;
                ans++;
            } else if (visited[num2]) {
                visited[num1] = true;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
