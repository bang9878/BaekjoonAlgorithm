import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long M;

	static int[] auditTime;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());

		auditTime = new int[N];
		for (int i = 0; i < N; i++) {
			auditTime[i] = Integer.parseInt(br.readLine());
			max = Math.max(auditTime[i], max);
		}

		long left = 1;
		long right = max * ((M / N) + 1);
		long result = 1;

		while (left + 1 < right) {

			long mid = (left + right) / 2;

			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum += (mid / auditTime[i]);
			}

			if (M <= sum) {
				right = mid;
				result = mid;
			} else {
				left = mid;
			}

		}

		System.out.println(result);

	}

}
