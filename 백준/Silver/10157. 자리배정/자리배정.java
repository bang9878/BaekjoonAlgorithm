import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[][] arr = new int[r][c];

		int k = Integer.parseInt(br.readLine());

		if (r * c < k) {
			System.out.println("0");
			return;
		}

		int[] dirR = { 0, 1, 0, -1 };
		int[] dirC = { 1, 0, -1, 0 };
		boolean[][] visited = new boolean[r][c];

		int curR = 0;
		int curC = 0;
		int idx = 0;
		for (int i = 0; i < k; i++) {
			
			if(i == k -1) {
				System.out.println((curR + 1) + " " + (curC + 1));
				return;
			}
			
			
			visited[curR][curC] = true;
			
			int nextR = curR + dirR[idx];
			int nextC = curC + dirC[idx];

			if (!isIn(nextR, nextC) || visited[nextR][nextC]) {
				
				idx = (idx + 1) % 4;
				
				nextR = curR + dirR[idx];
				nextC = curC + dirC[idx];
			}
			
			

			curR = nextR;
			curC = nextC;

		}
		

	}

	public static boolean isIn(int curR, int curC) {
		return 0 <= curR && curR < r && 0 <= curC && curC < c;
	}
}
