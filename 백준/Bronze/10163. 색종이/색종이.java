import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[1001][1001];
		int[] res = new int[N + 1];
		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine());

			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int j = startR; j < startR + w; j++) {
				for (int k = startC; k < startC + h; k++) {
					if (arr[j][k] != 0) {
						res[arr[j][k]]--;
					}
					arr[j][k] = i;
					res[i]++;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(res[i]);
		}

	}
}
