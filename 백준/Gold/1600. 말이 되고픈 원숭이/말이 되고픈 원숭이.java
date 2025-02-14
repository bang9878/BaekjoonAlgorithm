import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, R, C;
	static boolean isArrive;

	static int[][] map;
	static boolean[][][] visited;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	static int[] horseDirR = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] horseDirC = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		input();
		bfs();
		if (!isArrive) {
			System.out.println("-1");
		}
	}

	public static void bfs() {
		Queue<Monkey> q = new LinkedList<Monkey>();
		q.add(new Monkey(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Monkey cur = q.poll();

			if (cur.r == R - 1 && cur.c == C - 1) {
				isArrive = true;
				System.out.println(cur.moveCnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextR = cur.r + dirR[i];
				int nextC = cur.c + dirC[i];

				if (isIn(nextR, nextC) && !visited[nextR][nextC][cur.horse] && map[nextR][nextC] == 0) {
					visited[nextR][nextC][cur.horse] = true;
					q.add(new Monkey(nextR, nextC, cur.horse, cur.moveCnt + 1));
				}
			}

			if (cur.horse < K) {
				for (int i = 0; i < 8; i++) {
					int nextR = cur.r + horseDirR[i];
					int nextC = cur.c + horseDirC[i];

					if (isIn(nextR, nextC) && !visited[nextR][nextC][cur.horse + 1] && map[nextR][nextC] == 0) {
						visited[nextR][nextC][cur.horse + 1] = true;
						q.add(new Monkey(nextR, nextC, cur.horse + 1, cur.moveCnt + 1));
					}
				}
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C][K + 1];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

class Monkey {
	int r;
	int c;
	int horse;
	int moveCnt;

	public Monkey(int r, int c, int horse, int moveCnt) {
		this.r = r;
		this.c = c;
		this.horse = horse;
		this.moveCnt = moveCnt;
	}
}
