import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int BINGO_SIZE = 5;
	static int[][] participantMap = new int[BINGO_SIZE][BINGO_SIZE];

	// 사회자가 부르는 값
	static int[][] moderator = new int[BINGO_SIZE][BINGO_SIZE];
	// 빙고 결과를 담는 배열
	static int[][] bingoMap = new int[BINGO_SIZE][BINGO_SIZE];

	static int bingoCnt = 0;

	public static void main(String[] args) throws IOException {
		input();
		gameStart();
	}

	public static void gameStart() {
		int result = 0;
		for (int i = 0; i < BINGO_SIZE; i++) {
			for (int j = 0; j < BINGO_SIZE; j++) {
				result++;
				check(moderator[i][j]);
				validationBingo();
				if (bingoCnt >= 3) {
					System.out.println(result);
					return;
				}
			}
		}
	}

	public static void validationBingo() {

		// 가로줄
		int twoCnt;
		for (int i = 0; i < BINGO_SIZE; i++) {
			boolean isBingoLine = true;
			twoCnt = 0;
			for (int j = 0; j < BINGO_SIZE; j++) {

				if (bingoMap[i][j] == 0) {
					isBingoLine = false;
				} else if (bingoMap[i][j] == 2) {
					twoCnt++;
				}
			}
			if (isBingoLine && twoCnt != BINGO_SIZE) {
				bingoCnt++;
				for (int j = 0; j < BINGO_SIZE; j++) {
					bingoMap[i][j] = 2;
				}
			}

		}

		// 세로줄

		for (int i = 0; i < BINGO_SIZE; i++) {
			boolean isBingoLine = true;
			twoCnt = 0;
			for (int j = 0; j < BINGO_SIZE; j++) {
				if (bingoMap[j][i] == 0) {
					isBingoLine = false;
				} else if (bingoMap[j][i] == 2) {
					twoCnt++;
				}
			}
			if (isBingoLine && twoCnt != BINGO_SIZE) {
				bingoCnt++;
				for (int j = 0; j < BINGO_SIZE; j++) {
					bingoMap[j][i] = 2;
				}
			}

		}

		// 아래쪽 대각선
		twoCnt = 0;
		boolean isBingoLine = true;
		for (int i = 0; i < BINGO_SIZE; i++) {
			if (bingoMap[i][i] == 0) {
				isBingoLine = false;
			} else if (bingoMap[i][i] == 2) {
				twoCnt++;
			}
		}
		if (isBingoLine && twoCnt != BINGO_SIZE) {
			for (int i = 0; i < BINGO_SIZE; i++) {
				bingoMap[i][i] = 2;
			}
			bingoCnt++;
		}

		// 위쪽 대각선
		// 40 31 22 13 04
		twoCnt = 0;
		isBingoLine = true;
		for (int i = 0; i < BINGO_SIZE; i++) {
			if (bingoMap[BINGO_SIZE - i - 1][i] == 0) {
				isBingoLine = false;
			} else if (bingoMap[BINGO_SIZE - i - 1][i] == 2) {
				twoCnt++;
			}
		}
		if (isBingoLine && twoCnt != BINGO_SIZE) {
			for (int i = 0; i < BINGO_SIZE; i++) {
				bingoMap[BINGO_SIZE - i - 1][i] = 2;
			}
			bingoCnt++;
		}

	}

	public static void check(int number) {
		for (int i = 0; i < BINGO_SIZE; i++) {
			for (int j = 0; j < BINGO_SIZE; j++) {
				// 0은 사회자가 안부름, 1은 사회자가 부름, 2는 빙고
				if (participantMap[i][j] == number) {
					bingoMap[i][j] = 1;
				}
			}
		}
	}

	public static void input() throws IOException {

		for (int i = 0; i < BINGO_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < BINGO_SIZE; j++) {
				participantMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < BINGO_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < BINGO_SIZE; j++) {
				moderator[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

}
