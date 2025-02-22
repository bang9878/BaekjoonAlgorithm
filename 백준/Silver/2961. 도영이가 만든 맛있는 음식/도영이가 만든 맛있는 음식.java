import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {

	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = parseInt(br.readLine());

		// 신맛
		int[] acidity = new int[N + 1];
		// 쓴맛
		int[] acerbity = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());

			acidity[i] = a;
			acerbity[i] = b;
		}

		dfs(1, acidity, acerbity, new boolean[N + 1]);
		System.out.println(min);
	}

	public static void dfs(int depth, int[] acidity, int[] acerbity, boolean[] visited) {

		if (depth == N + 1) {
			minCheck(acidity, acerbity, visited);
			return;
		}

		visited[depth] = true;
		dfs(depth + 1, acidity, acerbity, visited);

		visited[depth] = false;
		dfs(depth + 1, acidity, acerbity, visited);
	}

	public static void minCheck(int[] acidity, int[] acerbity, boolean[] visited) {

		boolean isSelected = false;
		int acidSum = 1;
		int acerbSum = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				isSelected = true;
				acidSum *= acidity[i];
				acerbSum += acerbity[i];
			}
		}

		if (!isSelected) {
			return;
		}

		int result = Math.abs(acidSum - acerbSum);

		min = Math.min(min, result);
	}
}
