import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			int sameLeagueCnt = 0;
			int anotherLeagueCnt = 0;

			for (int i = 1; i < M; i++) {
				sameLeagueCnt += i;
			}

			for (int i = 1; i < N; i++) {
				anotherLeagueCnt += i;
			}

			int B = 1;
			int A;
			int result = -1;
			int pow = M * M * anotherLeagueCnt;

			while (true) {
				A = B * k;

				// 다른 지역리그 계산

				int anotherLeague = pow * B;

				// 같은 지역리그 계산
				int sameLeague = sameLeagueCnt * N * A;

				int total = anotherLeague + sameLeague;

				if (total > D) {
					break;
				}

				result = total;
				B++;

			}

			System.out.println(result);

		}
	}
}