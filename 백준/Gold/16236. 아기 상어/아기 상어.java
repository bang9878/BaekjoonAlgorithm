import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	static ArrayList<Fish> fishList; // 상어가 먹을 수 있는 크기의 물고기들만 담음

	static int sharkR, sharkC;
	static int sharkSize = 2;

	static int time;
	static int cnt;

	public static void main(String[] args) throws Exception {

		input();
		while (true) {

			fishList = new ArrayList<>();

			// 거리 계산해서 먹으러 갈 수 있는 물고기들을 넣어놓는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && map[i][j] != 9 && map[i][j] < sharkSize) {
						int dis = calcDis(i, j);
						if (dis != -1) {
							fishList.add(new Fish(i, j, map[i][j], dis));
						}
					}
				}
			}

			if (fishList.size() == 0) {
				System.out.println(time);
				return;
			}

			// 넣어논 것들 중 조건에 부합한 녀석을 먹으러 간다.
			Collections.sort(fishList);
			Fish fish = fishList.get(0);
			time += fish.dis;
			map[sharkR][sharkC] = 0;
			map[fish.r][fish.c] = 9;
			sharkR = fish.r;
			sharkC = fish.c;
			cnt++;
			if (cnt == sharkSize) {
				cnt = 0;
				sharkSize++;
			}
		}

	}

	public static int calcDis(int r, int c) {

		boolean[][] visited = new boolean[N][N];

		Queue<Shark> q = new LinkedList<>();
		q.add(new Shark(sharkR, sharkC, sharkSize, 0));
		visited[sharkR][sharkC] = true;

		while (!q.isEmpty()) {

			Shark cur = q.poll();

			// 먹었음
			if (cur.r == r && cur.c == c) {
				return cur.dis;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dirR[i];
				int nc = cur.c + dirC[i];

				if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] > sharkSize)
					continue;

				visited[nr][nc] = true;
				q.add(new Shark(nr, nc, sharkSize, cur.dis + 1));

			}

		}

		return -1;

	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkR = i;
					sharkC = j;
				}
			}
		}

	}
}

class Fish implements Comparable<Fish> {
	int r;
	int c;
	int size;
	int dis;

	public Fish(int r, int c, int size, int dis) {
		this.r = r;
		this.c = c;
		this.size = size;
		this.dis = dis;
	}

	@Override
	public int compareTo(Fish o) {
		if (this.dis != o.dis) {
			return Integer.compare(this.dis, o.dis);
		}

		if (this.r != o.r) {
			return Integer.compare(this.r, o.r);
		}

		return Integer.compare(this.c, o.c);
	}
}

class Shark {
	int r;
	int c;
	int size;
	int dis;

	public Shark(int r, int c, int size, int dis) {
		this.r = r;
		this.c = c;
		this.size = size;
		this.dis = dis;
	}
}
