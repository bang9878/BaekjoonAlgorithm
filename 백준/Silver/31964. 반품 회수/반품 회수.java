import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] X = new int[N];
		int[] T = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(st.nextToken());
		}

		int curT = Math.max(X[N - 1], T[N - 1]);

		for (int i = N - 2; i >= 0; i--) {

			curT += X[i + 1] - X[i];

			if (curT < T[i]) {
				curT = T[i];
			}

		}

		curT += X[0];

		System.out.println(curT);
	}
}
