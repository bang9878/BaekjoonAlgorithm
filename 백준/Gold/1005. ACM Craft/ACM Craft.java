import java.io.*;
import java.util.*;

public class Main {

	static int N, K, W; // 건물 개수, 간선 개수, 지어야 할 건물 번호
	static ArrayList<Integer>[] graph;
	static int[] time;

	static int[] indegree;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			time = new int[N + 1];
			indegree = new int[N + 1];
			graph = new ArrayList[N + 1];

			for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				indegree[to]++;
				graph[from].add(to);
			}

			W = Integer.parseInt(br.readLine());
			bfs();
		}
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
			dp[i] = time[i];
		}

		while (!q.isEmpty()) {

			int cur = q.poll();

			for (int next : graph[cur]) {
				dp[next] = Math.max(dp[next], dp[cur] + time[next]);
				if (--indegree[next] == 0) {
					q.add(next);
				}
			}

		}
		sb.append(dp[W]).append('\n');
	}
}