import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N=Integer.parseInt(br.readLine());
		List<int[]> arr = new ArrayList<>(); // List 정렬 속도가 더 빨라서 이거 사용...100000개니까
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int[] tmp= new int[2];
			tmp[0]  = Integer.parseInt(st.nextToken());
			tmp[1]  = Integer.parseInt(st.nextToken());
			arr.add(tmp);
		} // 값을 받아와서
		arr.sort( new Comparator<int[]>() { // 끝나는시간 기준으로 정렬.
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1]!=o2[1])
				return o1[1]-o2[1];
				else return o1[0]-o2[0]; // 끝나는 시간이 같으면 시작 시간으로 정렬
			}
		});
		
		int answer = 0; // 정답
		int end = 0; // 현재까지 끝나는 시간
		for (int i=0;i<N;i++) { // 돌면서
			if (arr.get(i)[0]>=end) { // 해당 회의 시작시간이 현재 회의 끝나고 이후면
				end = arr.get(i)[1]; // 해당 회의를 한다고 생각하고, end에 그 회의 끝나는 시간을 넣고
				answer++; // 정답을 하나 키워줌
			}
		}
		System.out.println(answer); // 정답을 프린트
	}
}