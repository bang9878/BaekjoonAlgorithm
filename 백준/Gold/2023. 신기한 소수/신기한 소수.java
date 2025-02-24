import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dfs(0, 0);
		System.out.println(sb);

	}

	public static void dfs(int num, int depth) {
		if (depth == N) {
			sb.append(num).append('\n');
			return;
		}

		for (int i = 0; i < 10; i++) {
			int tmp = num * 10 + i;
			if (isPrime(tmp)) {
				dfs(tmp, depth + 1);
			}
		}

	}

	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}

		return true;
	}
}
