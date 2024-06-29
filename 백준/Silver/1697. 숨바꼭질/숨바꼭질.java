import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int subin;
	static int sister;
	static int time = 0;
	static boolean[] visited;
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		subin = Integer.parseInt(st.nextToken());
		sister = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];

		bfs(subin);

		System.out.println(res);
	}

	static void bfs(int curPosition) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(curPosition, time));

		while (!q.isEmpty()) {
			Node tmp = q.poll();

			if (tmp.curPos == sister) {
				res = tmp.time;
				return;
			}

			if (isRange(tmp.curPos + 1) && !visited[tmp.curPos + 1]) {
				visited[tmp.curPos] = true;
				q.add(new Node(tmp.curPos + 1, tmp.time + 1));
			}
			if (isRange(tmp.curPos - 1) && !visited[tmp.curPos - 1]) {
				visited[tmp.curPos] = true;
				q.add(new Node(tmp.curPos - 1, tmp.time + 1));
			}
			if (isRange(tmp.curPos * 2) && !visited[tmp.curPos * 2]) {
				visited[tmp.curPos] = true;
				q.add(new Node(tmp.curPos * 2, tmp.time + 1));
			}
		}
	}

	static boolean isRange(int point) {
		return 0 <= point && point < 100001;
	}
}

class Node {
	int time;
	int curPos;

	Node(int curPos, int time) {
		this.curPos = curPos;
		this.time = time;
	}
}
