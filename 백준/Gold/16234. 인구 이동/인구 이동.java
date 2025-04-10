import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R;
	static int[][] map;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	static int ans;
	static boolean isOpen;

	public static void main(String[] args) throws Exception {
		input();

		int[][] cloneMap = new int[N][N];

		while (true) {
			isOpen = false;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j])
						bfs(visited, i, j, cloneMap);
				}
			}

			if (!isOpen) {
				System.out.println(ans);
				return;
			}
			++ans;

			// 결과 맵 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = cloneMap[i][j];
				}
			}
		}

	}

	public static void bfs(boolean[][] visited, int r, int c, int[][] cloneMap) {

		Queue<Country> q = new LinkedList<>();
		q.add(new Country(r, c, map[r][c]));
		visited[r][c] = true;

		int sum = 0;
		ArrayList<Country> share = new ArrayList<>();
		while (!q.isEmpty()) {

			Country cur = q.poll();

			sum += cur.population;
			share.add(new Country(cur.r, cur.c));

			for (int d = 0; d < 4; d++) {

				int nr = cur.r + dirR[d];
				int nc = cur.c + dirC[d];

				if (!isIn(nr, nc) || visited[nr][nc])
					continue;
				int diff = Math.abs(map[cur.r][cur.c] - map[nr][nc]);
				if (diff >= L && diff <= R) {
					visited[nr][nc] = true;
					q.add(new Country(nr, nc, map[nr][nc]));
				}
			}
		}

		if (share.size() >= 2) {
			isOpen = true;
		}

		int calcPop = sum / share.size();
		for (Country country : share) {
			cloneMap[country.r][country.c] = calcPop;
		}

	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

}

class Country {
	int r;
	int c;
	int population;

	public Country(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public Country(int r, int c, int population) {
		this.r = r;
		this.c = c;
		this.population = population;
	}
}
