import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] covered;
	static int[] paper;
	static int answer;
	static List<int[]> todo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10][10];
		covered = new boolean[10][10];
		paper = new int[6];
		answer = -1;
		todo = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					todo.add(new int[] { i, j });
			}
		}
		back(0);
		System.out.println(answer);
	}

	static void back(int idx) {
		if (idx == todo.size()) {
			int sum = 0;
			for(int i=1;i<=5;i++) sum+=paper[i];
			if (answer == -1) {
				answer = sum;
			} else {
				answer = Math.min(answer, sum);
			}
			return;
		}
		int[] now = todo.get(idx);
		int i = now[0];
		int j = now[1];
		if (covered[i][j])
			back(idx + 1);
		else {
			outer: for (int k = 1; k <= 5; k++) {
				// 해당 색종이로 커버 가능한지 체크.
				// 일단 색종이가 남았는지 체크
				if (paper[k] == 5)
					continue;
				// 색종이가 없거나 이미 덮인 부분(겹치는 부분)이 있으면 그 다음꺼도 안되니까 걍 break 하기
				for(int a = i;a<i+k;a++) {
					for (int b=j;b<j+k;b++) {
						// 범위체크도 하기
						if (a>=10 || b>=10 ||arr[a][b]!=1 || covered[a][b]) break outer;
					}
				}
				// 여기까지 온건 덮는게 가능하다는 것이니까
				paper[k]++;
				for(int a = i;a<i+k;a++) {
					for (int b=j;b<j+k;b++) {
						covered[a][b] = true;
					}
				}
				back(idx+1);
				paper[k]--;
				for(int a = i;a<i+k;a++) {
					for (int b=j;b<j+k;b++) {
						covered[a][b] = false;
					}
				}
			}
		}
	}
}