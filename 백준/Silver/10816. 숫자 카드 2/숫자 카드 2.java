import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		
		for (int i=0;i<n;i++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key)) {
				int value = map.get(key);
				map.put(key, ++value);
			} else {
				map.put(key, 1);
			}
		}
		st=new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<m;i++) {
			int key=Integer.parseInt(st.nextToken());
			if (map.containsKey(key)) bw.write(map.get(key)+" ");
			else bw.write("0 ");
		}
		bw.flush();
		bw.close();
	}
}