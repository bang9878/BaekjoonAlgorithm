import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] peoples;
	static int[][] map;
	static boolean[] isChoice;

	static int moveCnt = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		input();
		for (int i = 1; i <= N / 2; i++) {
			isChoice = new boolean[N + 1];
			combination(1, 0, i);
		}

		min = (min == Integer.MAX_VALUE) ? -1 : min;
		System.out.println(min);
	}

	public static void combination(int start, int depth, int r) {
		if (depth == r) {
			ArrayList<Integer> choiceList = new ArrayList<>();
			ArrayList<Integer> notChoiceList = new ArrayList<>();

			int choiceSum = 0;
			int notChoiceSum = 0;

			boolean isConnected = true;
			for (int i = 1; i <= N; i++) {
				if (isChoice[i]) {
					choiceList.add(i);
					choiceSum += peoples[i];
				} else {
					notChoiceList.add(i);
					notChoiceSum += peoples[i];
				}
			}

			// 조합으로 선택한 것들이 연결되어 있는지를 확인
			moveCnt = 1;
			boolean[] visited = new boolean[N + 1];
			visited[choiceList.get(0)] = true;
			dfs(choiceList.get(0), choiceList, visited);
			if (moveCnt != choiceList.size()) {
				isConnected = false;
			}

			// 선택하지 않은 남은 것들이 연결되어 있는지를 확인
			moveCnt = 1;
			visited = new boolean[N + 1];
			visited[notChoiceList.get(0)] = true;
			dfs(notChoiceList.get(0), notChoiceList, visited);
			if (moveCnt != notChoiceList.size()) {
				isConnected = false;
			}

			if (isConnected) {
//				System.out.println("notChoiceSum: " + notChoiceSum);
//				System.out.println("choiceSum: " + choiceSum);
				min = Math.min(Math.abs(notChoiceSum - choiceSum), min);
			}
			return;
		}

		for (int i = start; i <= N; i++) {
			isChoice[i] = true;
			combination(i + 1, depth + 1, r);
			isChoice[i] = false;
		}
	}

	public static void dfs(int node, ArrayList<Integer> list, boolean[] visited) {

		for (int i = 1; i <= N; i++) {
			if (map[node][i] == 1 && !visited[i]) {
				for (int j = 0; j < list.size(); j++) {
					if (i == list.get(j)) {
						visited[i] = true;
						moveCnt++;
						dfs(i, list, visited);
					}
				}
			}
		}
	}

	public static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		peoples = new int[N + 1];
		map = new int[N + 1][N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int neighborCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < neighborCnt; j++) {
				int neighborIdx = Integer.parseInt(st.nextToken());

				map[i][neighborIdx] = 1;
			}
		}
	}
}
