import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, d, K, c;
	static int[] sushi;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N];
		visited = new int[d + 1];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int init = 1;
		visited[c]++;
		for (int i = 0; i < K; i++) {
			if (visited[sushi[i]] != 0) {
				visited[sushi[i]]++;
				continue;
			}
			init++;
			visited[sushi[i]]++;
		}

		int idx = -1;
		int max = init;
		for (int i = 1; i < N; i++) {
			if ((i + K - 1) >= N) {
				idx = (i + K - 1) % N;
			} else {
				idx = i + K - 1;
			}

			// 하나 추가
			if (visited[sushi[idx]] == 0) {
				init++;
			}
			visited[sushi[idx]]++;

			// 하나 빼기
			if (visited[sushi[i - 1]] == 1) {
				init--;
			}
			visited[sushi[i - 1]]--;

			max = Math.max(max, init);
		}

		System.out.println(max);

	}

}