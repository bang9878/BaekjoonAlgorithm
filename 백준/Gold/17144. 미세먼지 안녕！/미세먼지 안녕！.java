import java.util.*;
import java.io.*;

public class Main {

	static int R, C, T;
	static int[][] map;
	static int[][] copyMap;

	static int topIdx, botIdx;
	static int topR, topC;
	static int botR, botC;

	static int[] botDirR = { 0, 1, 0, -1 };
	static int[] botDirC = { 1, 0, -1, 0 };

	static int[] topDirR = { 0, -1, 0, 1 };
	static int[] topDirC = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		input();

		for (int t = 0; t < T; t++) {
			dustMove(); // 먼지 확산
			airMove();
		}

		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1)
					sum += map[i][j];
			}
		}
		
		System.out.println(sum);

	}

	public static void airMove() {
		ArrayList<Integer> dustList = new ArrayList<>();

		// top 공기 청정기 밀어낼 먼지 담기
		dustList.add(0);
		int idx = 0;
		while (true) {

			int nr = topR + topDirR[idx];
			int nc = topC + topDirC[idx];

			if (!isIn(nr, nc)) {
				idx = (idx + 1) % 4;
				nr = topR + topDirR[idx];
				nc = topC + topDirC[idx];
			}

			if (map[nr][nc] != -1) {
				dustList.add(map[nr][nc]);
			}

			topR = nr;
			topC = nc;

			if (map[topR][topC] == -1) {
				break;
			}

		}

		int tmpTopR = topR;
		int tmpTopC = topC;
		int listIdx = 0;
		idx = 0;
		while (true) {
			int nr = tmpTopR + topDirR[idx];
			int nc = tmpTopC + topDirC[idx];

			if (!isIn(nr, nc)) {
				idx = (idx + 1) % 4;
				nr = tmpTopR + topDirR[idx];
				nc = tmpTopC + topDirC[idx];
			}

			if (map[nr][nc] == -1)
				break;

			map[nr][nc] = dustList.get(listIdx);

			tmpTopR = nr;
			tmpTopC = nc;
			listIdx++;
		}

		// bottom 공기 청정기
		dustList.clear();
		idx = 0;
		dustList.add(0);
		while (true) {

			int nr = botR + botDirR[idx];
			int nc = botC + botDirC[idx];

			if (!isIn(nr, nc)) {
				idx = (idx + 1) % 4;
				nr = botR + botDirR[idx];
				nc = botC + botDirC[idx];
			}

			if (map[nr][nc] != -1) {
				dustList.add(map[nr][nc]);
			}

			botR = nr;
			botC = nc;

			if (map[botR][botC] == -1) {
				break;
			}

		}

		int tmpBotR = botR;
		int tmpBotC = botC;
		listIdx = 0;
		idx = 0;
		while (true) {
			int nr = tmpBotR + botDirR[idx];
			int nc = tmpBotC + botDirC[idx];

			if (!isIn(nr, nc)) {
				idx = (idx + 1) % 4;
				nr = tmpBotR + botDirR[idx];
				nc = tmpBotC + botDirC[idx];
			}

			if (map[nr][nc] == -1)
				break;

			map[nr][nc] = dustList.get(listIdx);

			tmpBotR = nr;
			tmpBotC = nc;
			listIdx++;
		}
	}

	public static void dustMove() {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 4) {
					int spreadSize = map[i][j] / 5;
					int spreadCnt = 0;
					for (int d = 0; d < 4; d++) {

						int nr = i + topDirR[d];
						int nc = j + topDirC[d];

						if (isIn(nr, nc) && map[nr][nc] != -1) {
							copyMap[nr][nc] += spreadSize;
							spreadCnt++;
						}
					}
					copyMap[i][j] -= spreadCnt * spreadSize;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = copyMap[i][j];
			}
		}

	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		copyMap = new int[R][C];
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && !flag) {
					topR = i;
					topC = j;
					botR = i + 1;
					botC = j;
					flag = true;
				}
			}
		}
	}
}
