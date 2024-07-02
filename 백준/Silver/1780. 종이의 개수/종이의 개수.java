import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[][] paper;
	static int N;
	static int zeroCnt = 0;
	static int oneCnt = 0;
	static int minusCnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cutting(0, 0, N);

		System.out.println(minusCnt);
		System.out.println(zeroCnt);
		System.out.println(oneCnt);
	}

	static void cutting(int col, int row, int size) {
		if (chk(col, row, size)) {
			if (paper[col][row] == 0)
				zeroCnt++;
			else if (paper[col][row] == 1)
				oneCnt++;
			else if (paper[col][row] == -1)
				minusCnt++;

			return;
		}

		int newSize = size / 3;

		cutting(col, row, newSize);
		cutting(col, row + newSize, newSize);
		cutting(col, row + (newSize * 2), newSize);
		cutting(col + newSize, row, newSize);
		cutting(col + newSize, row + newSize, newSize);
		cutting(col + newSize, row + (newSize * 2), newSize);
		cutting(col + (newSize * 2), row, newSize);
		cutting(col + (newSize * 2), row + newSize, newSize);
		cutting(col + (newSize * 2), row + (newSize * 2), newSize);

	}

	static boolean chk(int col, int row, int size) {
		int chkNum = paper[col][row];

		for (int i = col; i < col + size; i++) {
			for (int j = row; j < row + size; j++) {
				if (chkNum != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
