import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {

	static class Cell {
		int r;
		int c;
		int cnt;
		int dir;

		public Cell(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + ", cnt=" + cnt + ", dir=" + dir + "]";
		}

	}

	static int N, time, K;
	static Cell[][] map;
	static List<Cell>[][] cellArr;

	// 상, 하, 좌, 우
	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new Cell[N][N];
			cellArr = new ArrayList[N][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;

				map[r][c] = new Cell(r, c, cnt, dir);
			}

			int t = 1;
			while (t <= time) {

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						cellArr[i][j] = new ArrayList<>();
					}
				}

				simulation();
				t++;
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != null) {
						result += map[i][j].cnt;
					}
				}
			}
			sb.append("#" + tc + " " + result).append('\n');
		}
		System.out.print(sb);
	}

	public static void simulation() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Cell cur = map[i][j];
				if (Objects.nonNull(cur)) {
					int nr = i + dirR[cur.dir];
					int nc = j + dirC[cur.dir];

					// 약품구역에 들어오면 군집수가 절반이 줄고 방향이 반대방향으로
					if (isMedicineArea(nr, nc)) {
						int cnt = cur.cnt / 2;
						if (cnt == 0) { // 0이면 없어짐
							map[i][j] = null;
						} else {
//							cur.r = nr;
//							cur.c = nc;
//							cur.dir = getTurnDir(cur.dir);
//							cur.cnt = cnt;
							cellArr[nr][nc].add(new Cell(nr, nc, cnt, getTurnDir(cur.dir)));
							map[i][j] = null;
						}
						continue;
					}
//					System.out.println(nr + " " + nc);
					map[i][j] = null;
					cellArr[nr][nc].add(new Cell(nr, nc, cur.cnt, cur.dir));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cellArr[i][j].size() == 0)
					continue;
				if (cellArr[i][j].size() == 1) {
					map[i][j] = cellArr[i][j].get(0);
				} else {
					int max = 0;
					int sum = 0;
					int dir = -1;
					for (Cell c : cellArr[i][j]) {
						sum += c.cnt;
						if (max < c.cnt) {
							max = c.cnt;
							dir = c.dir;
						}
					}
					map[i][j] = new Cell(i, j, sum, dir);
				}
			}
		}

	}

	public static int getTurnDir(int dir) {
		if (dir == 0) {
			return 1;
		} else if (dir == 1) {
			return 0;
		} else if (dir == 2) {
			return 3;
		} else if (dir == 3) {
			return 2;
		}

		return -1;
	}

	public static boolean isMedicineArea(int r, int c) {
		return r == 0 || r == N - 1 || c == 0 || c == N - 1;
	}

}