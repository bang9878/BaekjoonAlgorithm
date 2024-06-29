import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	static int N;
	static int[][] paper;
	static int whiteCnt = 0;
	static int blueCnt = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		partition(N, 0, 0);
		
		System.out.println(whiteCnt);
		System.out.println(blueCnt);

	}

	static void partition(int len, int col, int row) {

		if (colorChk(len, col, row)) {
			if (paper[col][row] == 1) {
				blueCnt++;
				return;
			} else if (paper[col][row] == 0) {
				whiteCnt++;
				return;
			}
		}

		int newLen = len / 2;

		partition(newLen, col, row);
		partition(newLen, col, row + newLen);
		partition(newLen, col + newLen, row);
		partition(newLen, col + newLen, row + newLen);
	}

	static boolean colorChk(int len, int col, int row) {

		for (int i = col; i < col + len; i++) {
			for (int j = row; j < row + len; j++) {
				if (paper[col][row] != paper[i][j])
					return false;
			}
		}
		return true;
	}
}
