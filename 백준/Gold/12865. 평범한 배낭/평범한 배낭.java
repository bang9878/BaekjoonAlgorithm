import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] weights = new int[N + 1];
		int[] values = new int[N + 1];
		int[] dp = new int[K + 1];
		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			weights[i] = w;
			values[i] = v;
		}

		for (int i = 1; i <= N; i++) {
			for (int w = K; w - weights[i] >= 0; w--) {
				dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= K; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);

	}
}
