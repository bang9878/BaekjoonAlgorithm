import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int row;
	static int col;
	static int[][] map;
	static int storeCnt;

	static int startDirection;

	static int startR;
	static int startC;

	static int[] result;

	public static void main(String[] args) throws IOException {
		input();
		solution();
		int sum = 0;
		for (int i = 1; i <= storeCnt; i++) {
			if (result[i] != Integer.MAX_VALUE)
				sum += result[i];
		}

		System.out.println(sum);
	}

	public static void solution() {

		if (startDirection == 1) {
			int[] rightDirR = { 0, 1, 0, -1 };
			int[] rightDirC = { 1, 0, -1, 0 };
			int[] leftDirR = { 0, 1, 0, -1 };
			int[] leftDirC = { -1, 0, 1, 0 };

			move(rightDirR, rightDirC, leftDirR, leftDirC);

		} else if (startDirection == 2) {
			int[] rightDirR = { 0, -1, 0, 1 };
			int[] rightDirC = { 1, 0, -1, 0 };
			int[] leftDirR = { 0, -1, 0, 1 };
			int[] leftDirC = { -1, 0, 1, 0 };

			move(rightDirR, rightDirC, leftDirR, leftDirC);
		} else if (startDirection == 3) {
			int[] rightDirR = { 1, 0, -1, 0 };
			int[] rightDirC = { 0, 1, 0, -1 };
			int[] leftDirR = { -1, 0, 1, 0 };
			int[] leftDirC = { 0, 1, 0, -1 };

			move(rightDirR, rightDirC, leftDirR, leftDirC);
		} else if (startDirection == 4) {
			int[] rightDirR = { -1, 0, 1, 0 };
			int[] rightDirC = { 0, -1, 0, 1 };
			int[] leftDirR = { 1, 0, -1, 0 };
			int[] leftDirC = { 0, -1, 0, 1 };

			move(rightDirR, rightDirC, leftDirR, leftDirC);
		}

		// 1. 경비원 기준 오른쪽으로 돌기

		// 2. 경비원 기준 왼쪽으로 돌기
	}

	public static void move(int[] rightDirR, int[] rightDirC, int[] leftDirR, int[] leftDirC) {
		// 오른쪽
		int direction = 0;
		int tmpStartR = startR;
		int tmpStartC = startC;
		for (int i = 1; i < (2 * (row + 1)) + (2 * (col + 1)) - 4; i++) {
			int nextR = tmpStartR + rightDirR[direction];
			int nextC = tmpStartC + rightDirC[direction];

			
			if (!isIn(nextR, nextC)) {
				direction = (direction + 1) % 4;
				nextR = tmpStartR + rightDirR[direction];
				nextC = tmpStartC + rightDirC[direction];
			}

			if (map[nextR][nextC] == -1) {
				break;
			}

			if (map[nextR][nextC] != 0) {
				result[map[nextR][nextC]] = i;
			}

			tmpStartR = nextR;
			tmpStartC = nextC;
		}

		// 왼쪽
		tmpStartR = startR;
		tmpStartC = startC;
		for (int i = 1; i < (2 * (row + 1)) + (2 * (col + 1)) - 4; i++) {
			int nextR = tmpStartR + leftDirR[direction];
			int nextC = tmpStartC + leftDirC[direction];

			if (!isIn(nextR, nextC)) {
				direction = (direction + 1) % 4;
				nextR = tmpStartR + leftDirR[direction];
				nextC = tmpStartC + leftDirC[direction];
			}

			if (map[nextR][nextC] == -1) {
				break;
			}

			if (map[nextR][nextC] != 0) {
				result[map[nextR][nextC]] = Math.min(result[map[nextR][nextC]], i);
			}

			tmpStartR = nextR;
			tmpStartC = nextC;
		}
	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r <= row && 0 <= c && c <= col;
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		map = new int[row + 1][col + 1];

		storeCnt = Integer.parseInt(br.readLine());
		result = new int[storeCnt + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		for (int i = 1; i <= storeCnt; i++) {
			st = new StringTokenizer(br.readLine());

			int direction = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			if (direction == 1) {
				setPosition(direction, distance, i);
			} else if (direction == 2) {
				setPosition(direction, distance, i);
			} else if (direction == 3) {
				setPosition(direction, distance, i);
			} else if (direction == 4) {
				setPosition(direction, distance, i);
			}
		}

		st = new StringTokenizer(br.readLine());

		startDirection = Integer.parseInt(st.nextToken());
		int distance = Integer.parseInt(st.nextToken());
		// -1이 경비원 현 위치라 표시
		setPosition(startDirection, distance, -1);
	}

	public static void setPosition(int direction, int distance, int storeNum) {
		if (direction == 1) {
			map[0][distance] = storeNum;
			startR = 0;
			startC = distance;
		} else if (direction == 2) {
			map[row][distance] = storeNum;
			startR = row;
			startC = distance;
		} else if (direction == 3) {
			map[distance][0] = storeNum;
			startR = distance;
			startC = 0;
		} else if (direction == 4) {
			map[distance][col] = storeNum;
			startR = distance;
			startC = col;
		}
	}

}
