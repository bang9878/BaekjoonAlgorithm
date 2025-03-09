import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] indgree;

	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		input();
		bfs();
		for (int n : result) {
			System.out.print((n + 1) + " ");
		}
	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (indgree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {

			int curIdx = q.poll();

			result.add(curIdx);

			for (int next : graph[curIdx]) {
				if (--indgree[next] == 0)
					q.add(next);
			}

		}
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N];
		indgree = new int[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			graph[from].add(to);
			indgree[to]++;
		}

	}
}
