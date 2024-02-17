import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static int getChicken(int N, int M, List<int[]> house, List<int[]> chicken, int answer, int[] idxs, int nowIdx,
			int nowValue) {
		if (nowIdx == M) {
			int length = getLength(house, chicken, idxs);
			if (answer>length) answer = length;
			return answer;
		}
		for (int i=nowValue;i<chicken.size();i++) {
			idxs[nowIdx]=i;
			int re = getChicken(N, M, house, chicken, answer, idxs, nowIdx+1, i+1);
			if (re<answer)answer=re;
		} 
		return answer;
		
	}
	
	private static int getLength(List<int[]> house, List<int[]> chicken, int[] idxs) {
//		System.out.println(Arrays.toString(idxs));
		int answer= 0 ;
		for (int i=0;i<house.size();i++) {
			int len = Integer.MAX_VALUE;
			int[] nowhouse = house.get(i);
			for (int j=0;j<idxs.length;j++) {
				int temp = Math.abs(nowhouse[0]-chicken.get(idxs[j])[0])+Math.abs(nowhouse[1]-chicken.get(idxs[j])[1]);
				if (len>temp) len=temp;
			}
			answer+=len;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		List<int[]> house = new ArrayList<>();
		List<int[]> chicken = new ArrayList<>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n==0) continue;
				int[] temp = new int[2];
				temp[0]=i;
				temp[1] = j;
				if (n==1) {
					house.add(temp);
				} else if (n==2) {
					chicken.add(temp);
				}
			}
		}
		int[] idxs = new int[M];
		int answer = getChicken(N, M, house, chicken, Integer.MAX_VALUE, idxs, 0, 0);
		System.out.println(answer);
	}

	
}