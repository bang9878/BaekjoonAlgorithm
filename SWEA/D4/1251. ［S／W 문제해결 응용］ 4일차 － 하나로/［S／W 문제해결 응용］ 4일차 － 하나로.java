import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static double E;
	static long[][] pos;
	static IsLand[] isLandArr;
	static int[] parents;

	static long tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			pos = new long[N][2];
			parents = new int[N];
			isLandArr = new IsLand[(N * (N - 1)) / 2];

			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pos[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());

			makeEdge();

			long result = 0L;
			int count = 0;
			for (IsLand island : isLandArr) {
				if (union(island.from, island.to)) {
					result += island.cost;
					if(++count == N-1)break;
				}
			}

			sb.append("#" + tc + " " + Math.round(result*E)).append('\n');
		}
		System.out.print(sb);
	}

	public static void makeEdge() {
		int idx = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				isLandArr[idx++] = new IsLand(i, j, calcCost(pos[i][0], pos[i][1], pos[j][0], pos[j][1]));
			}
		}
		Arrays.sort(isLandArr);
	}

	public static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		if (aRoot < bRoot)
			parents[bRoot] = aRoot;
		else
			parents[aRoot] = bRoot;
		return true;
	}

	public static long calcCost(long x1, long y1, long x2, long y2) {
		return ((x1 - x2) * (x1 - x2) * 1L) + ((y1 - y2) * (y1 - y2) * 1L);

	}
}

class IsLand implements Comparable<IsLand> {
	int from;
	int to;
	long cost;

	public IsLand() {

	}

	public IsLand(int from, int to, long cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(IsLand o) {
		return Long.compare(this.cost, o.cost);
	}

}