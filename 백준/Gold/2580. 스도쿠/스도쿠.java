import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku;
	static List<int[]> todo;
	static List<int[]> canNums;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		todo = new ArrayList<>();
		canNums = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0) 
					todo.add(new int[] { i, j });
			}
		}
		N = todo.size();
		for (int i=0;i<N;i++) {
			canNums.add(getNum(i));
		}
		doSudoku(0);

	}

	static void doSudoku(int idx) {
		if (idx == N) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

		int x = todo.get(idx)[0];
		int y = todo.get(idx)[1];
		for (int num : canNums.get(idx)) {
			sudoku[x][y] = num;
			if (!checkSudoku(x, y)) {
				sudoku[x][y]=0;
				continue;
			}
			doSudoku(idx+1);
			sudoku[x][y]=0;
		}
	}

	private static boolean checkSudoku(int x, int y) {
		boolean[] visited = new boolean[10];
		// 가로 체크
		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] == 0)
				continue;
			if (visited[sudoku[x][i]])
				return false;
			visited[sudoku[x][i]] = true;
		}

		// 세로 체크
		Arrays.fill(visited, false);
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][y] == 0)
				continue;
			if (visited[sudoku[i][y]])
				return false;
			visited[sudoku[i][y]] = true;
		}
		Arrays.fill(visited, false);
		// 사각형 체크
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[x / 3 * 3 + i][y / 3 * 3 + j] == 0)
					continue;
				if (visited[sudoku[x / 3 * 3 + i][y / 3 * 3 + j]])
					return false;
				visited[sudoku[x / 3 * 3 + i][y / 3 * 3 + j]] = true;
			}
		}
		return true;
	}

	// 필요한 숫자 가져오기
	static int[] getNum(int idx) {
		boolean[] hasnum = new boolean[10];
		int x = todo.get(idx)[0];
		int y = todo.get(idx)[1];
		// 가로 체크
		for (int i = 0; i < 9; i++) {
			hasnum[sudoku[x][i]] = true;
		}
		// 세로 체크
		for (int i = 0; i < 9; i++) {
			hasnum[sudoku[i][y]] = true;
		}
		// 사각형 체크
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				hasnum[sudoku[x / 3 * 3 + i][y / 3 * 3 + j]] = true;
			}
		}
		int num = 0;
		for (int i = 1; i <= 9; i++)
			if (!hasnum[i])
				num++;
		int[] result = new int[num];
		int resultIdx = 0;
		for (int i = 1; i <= 9; i++)
			if (!hasnum[i])
				result[resultIdx++] = i;
		return result;
	}
}