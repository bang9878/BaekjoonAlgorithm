import java.io.*;
import java.util.*;

public class Main {

	static int R, C;
	static char[][] map;

	static int curR, curC;
	static int endR, endC;

	static int missR, missC;

	static boolean isAns = false;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		input();

		int dir = -1;
		for (int d = 0; d < 4; d++) {
			int nr = curR + dirR[d];
			int nc = curC + dirC[d];

			if (isIn(nr, nc) && map[nr][nc] != '.' && map[nr][nc] != 'Z') {
				curR = nr;
				curC = nc;
				dir = d;
				break;
			}
		}
		dfs(curR, curC, dir, 'x', false);
	}

	public static void dfs(int r, int c, int dir, char need, boolean isFind) {

		if (isAns) {
			return;
		}

		if (!isIn(r, c))
			return;

//		System.out.println("r c dir " + r + " " + c + " " + dir);

		if (map[r][c] == 'Z' && !isAns) {
			System.out.println(missR + " " + missC + " " + need);
			isAns = true;
			return;
		}

		if (map[r][c] == '.' && !isFind) {

//			System.out.println("없는 곳: " + r + " " + c);
			missR = r + 1;
			missC = c + 1;
			if (dir == 0) {
				map[r][c] = '|';
				dfs(r - 1, c, 0, '|', true);
				map[r][c] = '.';

				map[r][c] = '+';
				dfs(r - 1, c, 0, '+', true);
				map[r][c] = '.';

				map[r][c] = '1';
				dfs(r, c + 1, 3, '1', true);
				map[r][c] = '.';

				map[r][c] = '4';
				dfs(r, c - 1, 2, '4', true);
				map[r][c] = '.';
			} else if (dir == 1) {

				map[r][c] = '|';
				dfs(r + 1, c, 1, '|', true);
				map[r][c] = '.';

				map[r][c] = '+';
				dfs(r + 1, c, 1, '+', true);
				map[r][c] = '.';

				map[r][c] = '2';
				dfs(r, c + 1, 3, '2', true);
				map[r][c] = '.';

				map[r][c] = '3';
				dfs(r, c - 1, 2, '3', true);
				map[r][c] = '.';
			} else if (dir == 2) {
				map[r][c] = '-';
				dfs(r, c - 1, 2, '-', true);
				map[r][c] = '.';

				map[r][c] = '+';
				dfs(r, c - 1, 2, '+', true);
				map[r][c] = '.';

				map[r][c] = '1';
				dfs(r + 1, c, 1, '1', true);
				map[r][c] = '.';

				map[r][c] = '2';
				dfs(r - 1, c, 0, '2', true);
				map[r][c] = '.';
			} else if (dir == 3) {

				map[r][c] = '-';
				dfs(r, c + 1, 3, '-', true);
				map[r][c] = '.';

				map[r][c] = '+';
				dfs(r, c + 1, 3, '+', true);
				map[r][c] = '.';

				map[r][c] = '3';
				dfs(r - 1, c, 0, '3', true);
				map[r][c] = '.';

				map[r][c] = '4';
				dfs(r + 1, c, 1, '4', true);
				map[r][c] = '.';
			}
		}

		switch (map[r][c]) {
		case '+':
			if (dir == 0) {
				dfs(r - 1, c, 0, need, isFind);
			} else if (dir == 1) {
				dfs(r + 1, c, 1, need, isFind);
			} else if (dir == 2) {
				dfs(r, c - 1, 2, need, isFind);
			} else if (dir == 3) {
				dfs(r, c + 1, 3, need, isFind);
			}
			break;
		case '|':
			if (dir == 0) {
				dfs(r - 1, c, dir, need, isFind);
			} else if (dir == 1) {
				dfs(r + 1, c, dir, need, isFind);
			}
			break;
		case '-':
			if (dir == 2) {
				dfs(r, c - 1, dir, need, isFind);
			} else if (dir == 3) {
				dfs(r, c + 1, dir, need, isFind);
			}
			break;
		case '1':
			if (dir == 2) {
				dfs(r + 1, c, 1, need, isFind);
			} else if (dir == 0) {
				dfs(r, c + 1, 3, need, isFind);
			}
			break;
		case '2':
			if (dir == 1) {
				dfs(r, c + 1, 3, need, isFind);
			} else if (dir == 2) {
				dfs(r - 1, c, 0, need, isFind);
			}
			break;
		case '3':
			if (dir == 3) {
				dfs(r - 1, c, 0, need, isFind);
			} else if (dir == 1) {
				dfs(r, c - 1, 2, need, isFind);
			}
			break;
		case '4':
			if (dir == 3) {
				dfs(r + 1, c, 1, need, isFind);
			} else if (dir == 0) {
				dfs(r, c - 1, 2, need, isFind);
			}
			break;
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

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'M') {
					curR = i;
					curC = j;
				} else if (map[i][j] == 'Z') {
					endR = i;
					endC = j;
				}
			}
		}
	}
}

class Node {
	int r;
	int c;
	int dir;

	public Node(int r, int c, int dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}