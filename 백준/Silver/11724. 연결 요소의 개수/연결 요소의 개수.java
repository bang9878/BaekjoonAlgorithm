import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static boolean[][] graph;
	static int node, edge;
	static int cnt = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());

		graph = new boolean[node + 1][node + 1];
		visited = new boolean[node + 1];

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[r][c] = true;
			graph[c][r] = true;
		}

		for (int i = 1; i <= node; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
			
		}

		System.out.println(cnt);

		bw.close();
		br.close();

	}

	static void bfs(int start) {
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int next = q.poll();
			for (int i = 1; i <= node; i++) {
				if (!visited[i] && graph[next][i]) {
					q.add(i);
					visited[i] = true;
				}
			}

		}
	}
}
