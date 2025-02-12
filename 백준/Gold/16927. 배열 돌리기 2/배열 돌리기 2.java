import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] arr;
	static int[][] res;

	static int[] dirR = { 0, -1, 0, 1 };
	static int[] dirC = { -1, 0, 1, 0 };

	// 찍을 곳을 찾는 방향배열
	static int[] printDirR = { 1, 0, -1, 0 };
	static int[] printDirC = { 0, 1, 0, -1 };

	// 돌릴 배열의 처음 r,c 와 끝 r,c
	static int startR, startC;
	static int endR, endC;

	static int printStartR, printStartC;
	static int curRLen, curCLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		res = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		curRLen = N;
		curCLen = M;

		endR = N - 1;
		endC = M - 1;
		while (true) {

			if (curRLen <= 0 || curCLen <= 0) {
				break;
			}
			int calcR = R % ((curRLen * 2) + (curCLen * 2) - 4);

			// 출력할 배열의 시작을 담음 printStartR, printStartC
			startPos(calcR);

			int[] printArr = new int[2 * curRLen + 2 * curCLen - 4];
			// 출력 배열에 1차원으로 저장
			savePrintArr(printArr);

			solution(printArr);

			startR += 1;
			startC += 1;
			endR -= 1;
			endC -= 1;
			curRLen = curRLen - 2;
			curCLen = curCLen - 2;

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void solution(int[] printArr) {

		int curR = printStartR;
		int curC = printStartC;
		int idx = -1;

		if (printStartC == endC) {
			idx = 3;
		} else if (printStartC == startC) {
			idx = 1;
		} else if (printStartR == startR) {
			idx = 2;
		} else if (printStartR == endR) {
			idx = 0;
		}

//		System.out.println("idx: " + idx);
//
//		System.out.println("solution");
//		System.out.println("startR: " + startR);
//		System.out.println("startC: " + startC);
//		System.out.println("endR: " + endR);
//		System.out.println("endC: " + endC);
//		System.out.println("printStartR: " + printStartR);
//		System.out.println("printStartC: " + printStartC);

		res[printStartR][printStartC] = printArr[0];
		for (int i = 1; i < (curRLen * 2) + (curCLen * 2) - 4; i++) {
			int nextR = curR + dirR[idx];
			int nextC = curC + dirC[idx];

			if (!isIn(nextR, nextC)) {
				idx = (idx + 1) % 4;

				nextR = curR + dirR[idx];
				nextC = curC + dirC[idx];
			}

//			System.out.println("nextR: " + nextR);
//			System.out.println("nextC: " + nextC);

			res[nextR][nextC] = printArr[i];

			curR = nextR;
			curC = nextC;
		}

	}

	public static void savePrintArr(int[] printArr) {
		int idx = 2;

		int curR = startR;
		int curC = startC;
		printArr[0] = arr[startR][startC];

		for (int i = 1; i < (curRLen * 2) + (curCLen * 2) - 4; i++) {
			int nextR = curR + dirR[idx];
			int nextC = curC + dirC[idx];

			if (!isIn(nextR, nextC)) {
				idx = (idx + 1) % 4;

				nextR = curR + dirR[idx];
				nextC = curC + dirC[idx];
			}

			printArr[i] = arr[nextR][nextC];

			curR = nextR;
			curC = nextC;
		}
	}

	public static void startPos(int calcR) {

		int curR = startR;
		int curC = startC;
		int idx = 0;
		for (int i = 0; i < calcR; i++) {
			int nextR = curR + printDirR[idx];
			int nextC = curC + printDirC[idx];

			if (!isIn(nextR, nextC)) {
				idx = (idx + 1) % 4;

				nextR = curR + printDirR[idx];
				nextC = curC + printDirC[idx];
			}

			curR = nextR;
			curC = nextC;

		}

		printStartR = curR;
		printStartC = curC;
	}

	public static boolean isIn(int r, int c) {
		return startR <= r && r <= endR && startC <= c && c <= endC;
	}

}
