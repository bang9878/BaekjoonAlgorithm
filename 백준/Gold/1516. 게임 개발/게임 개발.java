import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static ArrayList<Integer>[] graph;
	static int[] time;

	static int[] indegree;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		time = new int[N + 1];
		indegree = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());
			int from;
			while ((from = Integer.parseInt(st.nextToken())) != -1) {
				indegree[i]++;
				graph[from].add(i);
			}
		}

		bfs();
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
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
		for (int i = 1; i <= N; i++) {
			System.out.println(dp[i]);
		}
	}
}