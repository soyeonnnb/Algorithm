import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int idx = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            Integer key = map.getOrDefault(str, idx++);
            map.put(str, key);
            arr[key]++;
        }
        int result = N;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            String[] keywords = br.readLine().split(",");
            for(String str : keywords) {
                if (!map.containsKey(str)) continue;
                result -= arr[map.get(str)];
                arr[map.get(str)] = 0;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

}